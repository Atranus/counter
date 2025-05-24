package com.example.counter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter.posobility.PosobBinomP
import com.example.counter.posobility.PosobGeomP
import com.example.counter.posobility.PosobPuassP

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


    }
}