package com.example.counter

import android.content.Intent
import android.os.Bundle
import android.view.View
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
            btnModul.setOnClickListener {
                startActivity(Intent(this@MainActivity,Modul::class.java))
            }

            btnPosob.setOnClickListener {
                if (llPosob.visibility == View.GONE) {
                    btnPosob.text = "∧ Формулы по теории вероятности"
                    llPosob.setVisibility(View.VISIBLE)
                }
                else{
                    btnPosob.text = "∨ Формулы по теории вероятности"
                    llPosob.setVisibility(View.GONE)
                }
            }
            btnPosobBinom.setOnClickListener {
                startActivity(Intent(this@MainActivity,PosobBinomP::class.java))
            }
            btnPosobGeom.setOnClickListener {
                startActivity(Intent(this@MainActivity,PosobGeomP::class.java))
            }
            btnPosobPuass.setOnClickListener {
                startActivity(Intent(this@MainActivity,PosobPuassP::class.java))
            }
        }
    }
}