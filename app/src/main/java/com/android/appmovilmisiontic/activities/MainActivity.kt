package com.android.appmovilmisiontic.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.appmovilmisiontic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // esta linea de codigo sirve para llamar la activityMain xml dentro de la clase todos los componentes que hay dentro de esta
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //esta linea sirve para llamar el id del boton y abrir la nueva vista
        binding.start.setOnClickListener { start() }

    }


    fun start() {
        val inicio = Intent(this, LoginActivity::class.java)
        startActivity(inicio)
    }

}







