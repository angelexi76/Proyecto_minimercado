package com.android.appmovilmisiontic.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.appmovilmisiontic.R

class PagoFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

   override fun onCreateView(
       inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?// el signo de interrogacion confirmacion de no nulidad
    ): View? {
       val fragmento=inflater.inflate(R.layout.fragment_pago,container,false) //contiene la vista del fragemto
        return fragmento
    }



}

