package com.example.counter

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        with(binding){
            btnSqareEquation.setOnClickListener {
                startActivity(Intent(this@MainActivity,SqareEquation::class.java))
            }
            btnBisqareEquation.setOnClickListener {
                startActivity(Intent(this@MainActivity,BisqareEquation::class.java))
            }

        }
    }
}