package com.android.appmovilmisiontic.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.appmovilmisiontic.R
import com.android.appmovilmisiontic.bd.miSQLiteHelper
import com.android.appmovilmisiontic.databinding.ActivityRegistroBinding

class ActivityRegistro : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding
    lateinit var usuariosDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuariosDBHelper = miSQLiteHelper(this)
        binding.btnRegistro.setOnClickListener { registrarse() }

    }

    fun registrarse() {

        val nombre = binding.nombreUsuario.text
        val correo = binding.emailUsuario.text
        val password = binding.passwordUsuario.text
        val repetirPassword = binding.repetirPasswordUser.text

        if (nombre.isEmpty()) {
            binding.nombreLayout.error = "Debes llenar este campo!"
        } else {
            binding.nombreLayout.error = null
        }


        if (correo.isEmpty()) {
            binding.emailLayout.error = "Debes llenar este campo!"
        } else {
            binding.emailLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordLayout.error = "Debes llenar este campo!"
        } else {
            binding.passwordLayout.error = null
        }

        if (repetirPassword.isEmpty()) {
            binding.repetirPasswordLayout.error = "Debes llenar este campo!"
        } else {
            binding.repetirPasswordLayout.error = null
        }

        if (repetirPassword !== password) {
            if (correo.isNotEmpty() && password.isNotEmpty() && nombre.isNotEmpty() && repetirPassword.isNotEmpty()) {
                usuariosDBHelper.anyadirdato(
                    nombre.toString(),
                    correo.toString(),
                    password.toString()
                    )
                binding.nombreUsuario.text.clear()
                binding.emailUsuario.text.clear()
                binding.passwordUsuario.text.clear()
                binding.repetirPasswordUser.text.clear()
                Toast.makeText(this, "Usuario registrado exitosamente!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        } else {
            Toast.makeText(this, "Debes colocar contraseñas iguales!!", Toast.LENGTH_LONG).show()
        }

    }
}