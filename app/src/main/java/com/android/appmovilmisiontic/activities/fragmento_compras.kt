package com.android.appmovilmisiontic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.appmovilmisiontic.R

class fragmento_compras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmento_compras)
    }
    fun llamartarea(view:View){//adicionar el fragmento
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragment_container,PagoFragment::class.java,null,"pago")
            .commit()
    }
}