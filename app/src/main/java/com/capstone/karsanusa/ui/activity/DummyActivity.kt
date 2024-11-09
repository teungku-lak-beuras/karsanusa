package com.capstone.karsanusa.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.karsanusa.databinding.ActivityDummyBinding

class DummyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDummyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.dummyButtonToLogin.setOnClickListener {
            val intent = Intent(this@DummyActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
