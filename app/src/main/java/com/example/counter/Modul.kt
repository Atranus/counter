package com.example.counter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityBisqareEquationBinding
import com.example.counter.databinding.ActivityModulBinding

class Modul : AppCompatActivity() {

    private lateinit var binding: ActivityModulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityModulBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                val x = if (etX.text.isNotEmpty()) etX.text.toString().toLong() else 1.toLong()
                val m = if (etM.text.isNotEmpty()) etM.text.toString().toLong() else 10.toLong()

                if (etM.text.isEmpty()) {etM.setText("10")}

                if (m!= 0.toLong()){
                tvAnswer.text = "${x} mod($m) = ${x%m} mod($m)"
                }
                else tvAnswer.text = "Невозможно взять модуль числа при m = 0"
            }
        }
    }
}