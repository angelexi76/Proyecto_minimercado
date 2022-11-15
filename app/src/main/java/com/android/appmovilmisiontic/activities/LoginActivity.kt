package com.android.appmovilmisiontic.activities

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.appmovilmisiontic.bd.miSQLiteHelper
import com.android.appmovilmisiontic.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var usuariosDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuariosDBHelper = miSQLiteHelper(this)
        binding.log.setOnClickListener { entrarCatalogo() }

    }

    fun entrarCatalogo() {

        val correo = binding.txtCorreo!!.text
        val password = binding.txtPassword.text


        if (correo.isEmpty()) {
            binding.emailLayout!!.error = "Debes llenar este campo!"
        } else {
            binding.emailLayout!!.error = null
        }

        if (password.isEmpty()) {
            binding.passwordLayout!!.error = "Debes llenar este campo!"
        } else {
            binding.passwordLayout!!.error = null
        }

        if (correo.isNotEmpty() && password.isNotEmpty()) {
            val args= arrayOf(correo.toString(), password.toString())
            val db: SQLiteDatabase = usuariosDBHelper.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM usuarios " +
                        "WHERE email=? and password=?",
                args
            )

            var id: Int
            var nombreEncontrado: String
            var password: String
            if (cursor.moveToFirst()) {
                 do {
                    id = cursor.getInt(0)
                    nombreEncontrado = cursor.getString(1).toString()
                    password = cursor.getString(2).toString()
                } while (cursor.moveToNext())
                if (nombreEncontrado.isNotEmpty() && password.isNotEmpty()){
                    Toast.makeText(this, "Bienvenido $nombreEncontrado", Toast.LENGTH_LONG).show()
                    val inicio = Intent(this, CatActivity::class.java)
                    startActivity(inicio)
                }else{
                    Toast.makeText(this, "No se ha encontrado usuario con tus credenciales!", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Toast.makeText(this, "Debes colocar toda la informacion!!", Toast.LENGTH_LONG).show()
        }


    }


}