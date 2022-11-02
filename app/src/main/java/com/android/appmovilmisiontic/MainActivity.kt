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


    fun start(button1: View) {

        val inicio = Intent(this, MainActivity::class.java)
        startActivity(inicio)
    }
}







