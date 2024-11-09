package com.capstone.karsanusa.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.capstone.karsanusa.R
import com.capstone.karsanusa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.activity_main_fragment)

        binding.bottomNavigation.setupWithNavController(navController)

        // TODO: Implement a functional bottom navigation view
        //val navController = findNavController(R.id.fragment_container)
        //val appBarConfiguration = AppBarConfiguration(navController.graph)
        //binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        //binding.bottomNavigation.setupWithNavController(navController)
    }
}
