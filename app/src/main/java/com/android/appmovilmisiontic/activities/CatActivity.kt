package com.android.appmovilmisiontic.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.appmovilmisiontic.databinding.ActivityCatBinding
import com.android.appmovilmisiontic.databinding.ActivityLoginBinding

class CatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}