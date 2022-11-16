package com.android.appmovilmisiontic.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.android.appmovilmisiontic.R
import com.android.appmovilmisiontic.databinding.ActivityMapaBinding

import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var binding: ActivityMapaBinding

    lateinit var gMap: GoogleMap
    private var tienePermiso = false
    private val defaultLocation = LatLng(4.550923, -75.6557201)
    private lateinit var permissionResultCallBack: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        binding = ActivityMapaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getLocationPermission()

        permissionResultCallBack = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            when (it) {
                true -> {
                    tienePermiso = true
                    println("permiso aceptado")
                }
                false -> {
                    print("Permiso denegado")
                }
            }
        }



    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap
        gMap.uiSettings.isZoomControlsEnabled = true

        try {
            if (tienePermiso) {
                gMap.isMyLocationEnabled = true
                gMap.uiSettings.isMyLocationButtonEnabled = true
            } else {
                gMap.isMyLocationEnabled = false
                gMap.uiSettings.isMyLocationButtonEnabled = false
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

        obtenerUbicacion()

        gMap.addMarker(MarkerOptions().position(defaultLocation).title("Marker en Armenia"))
        gMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLocation))

    }


    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            tienePermiso = true
        } else {

        }
    }

    private fun obtenerUbicacion() {
        try {
            if (tienePermiso) {
                val ubicacionActual =
                    LocationServices.getFusedLocationProviderClient(this).lastLocation
                ubicacionActual.addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val ubicacion = it.result
                        if (ubicacion != null) {
                            val latlng = LatLng(ubicacion.latitude, ubicacion.longitude)
                            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15F))
                            gMap.addMarker(MarkerOptions().position(latlng).title("Marcador mapa"))
                        }
                    } else {
                        gMap.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                defaultLocation,
                                15F
                            )
                        )
                        gMap.uiSettings.isMyLocationButtonEnabled = false
                    }
                }
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message, e)
        }
    }


}