package com.example.counter

import android.os.Bundle
import android.view.View
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
                val A = if (etA.text.isNotEmpty()) etA.text.toString().toFloat() else 1F
                val B = if (etB.text.isNotEmpty()) etB.text.toString().toFloat()  else 1F
                val y = if (etY.text.isNotEmpty()) etY.text.toString().toFloat()  else 0F
                val C = (if (etC.text.isNotEmpty()) etC.text.toString().toFloat()  else 0F) - y

                val D = (B*B - 4*A*C)

                x1.setVisibility(View.GONE)
                x1Lable.text = "X₁ = "
                x2.setVisibility(View.GONE)
                d.setVisibility(View.GONE)
                tvAnswer.setVisibility(View.GONE)

                d.setVisibility(View.VISIBLE)
                dAnswer.text = " $B² - 4($A)($C) = $D"
                
                when {
                    (D > 0F) -> {
                        x1Up.text = "${(-B)} + ${sqrt(D)}"
                        x1Down.text = "${(2 * A)}"
                        x1Answer.text = " = ${((-B) + sqrt(D)) / (2 * A)}"
                        x2Up.text = "${(-B)} - ${sqrt(D)}"
                        x2Down.text = "${(2 * A)}"
                        x2Answer.text = " = ${((-B) - sqrt(D)) / (2 * A)}"

                        x1.setVisibility(View.VISIBLE)
                        x2.setVisibility(View.VISIBLE)
                    }
                    (D == 0F) -> {
                        x1Lable.text = "X = "
                        x1Up.text = "${(-B)}"
                        x1Down.text = "${(2 * A)}"
                        x1Answer.text = " = ${(-B) / (2 * A)}"
                        x1.setVisibility(View.VISIBLE)
                    }
                    (D < 0F) -> {
                        tvAnswer.setVisibility(View.VISIBLE)
                        tvAnswer.text = "Корней нет"
                    }
                }
            }
        }
    }
}