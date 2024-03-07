package com.example.autocollection.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autocollection.R
import com.example.autocollection.databinding.ActivityLoginBinding
import com.example.autocollection.ui.navigation.MainActivity
import com.example.autocollection.ui.startActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding:  ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.loguin.setOnClickListener{
            startActivity<MainActivity>()
        }

    }
}