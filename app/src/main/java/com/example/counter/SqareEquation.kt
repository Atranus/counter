package com.example.counter

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter.databinding.ActivitySqareEquationBinding
import kotlin.math.sqrt

class SqareEquation : AppCompatActivity() {

    private lateinit var binding: ActivitySqareEquationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySqareEquationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                val A = etA.text.toString().toFloat()
                val B = etB.text.toString().toFloat()
                val C = etC.text.toString().toFloat() - etY.text.toString().toFloat()

                val D = (B*B - 4*A*C)

                when {
                    (D > 0F) -> tvAnswer.text = "X1 = ${((-B)+sqrt(D))/(2*A)}\nX2 = ${((-B)-sqrt(D))/(2*A)}"
                    (D == 0F) -> tvAnswer.text = "X1 = ${((-B))/(2*A)}"
                    (D < 0F) -> tvAnswer.text = "Корней нет"
                }
            }
        }
    }
}