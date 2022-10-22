package com.android.appmovilmisiontic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun login1(btnlogin1:View){

        val ingreso1=Intent(this,ingreso_usuario::class.java)
        startActivity(ingreso1)
    }

    fun login(view: View) {
        val ingreso=Intent(this,ingreso_usuario::class.java)
        startActivity(ingreso)
    }


}

class ingreso_usuario {

}
