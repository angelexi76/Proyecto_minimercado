package com.android.appmovilmisiontic.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.android.appmovilmisiontic.R
import com.android.appmovilmisiontic.databinding.ActivityCatBinding
//import com.android.appmovilmisiontic.databinding.ActivityLoginBinding

class CatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.mi_barra))

        binding.verMapa.setOnClickListener { verMapa() }
    }

    fun verMapa(){
        val mapa = Intent(this, MapaActivity::class.java)
        startActivity(mapa)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tool_bar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean=when(item.itemId){
    R.id.itm_carro->{
        val carrito= Intent(this,fragmento_compras::class.java)
        startActivity(carrito)
        true
    }
        else->{
            super.onOptionsItemSelected(item)}


    }


}


