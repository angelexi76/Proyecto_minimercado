package com.android.appmovilmisiontic.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.appmovilmisiontic.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.log.setOnClickListener { entrarCatalogo() }
    }

    fun entrarCatalogo(){
        val inicio = Intent(this, CatActivity::class.java)
        startActivity(inicio)
    }


}