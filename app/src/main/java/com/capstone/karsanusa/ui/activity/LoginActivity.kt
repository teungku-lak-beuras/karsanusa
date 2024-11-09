package com.capstone.karsanusa.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.karsanusa.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
