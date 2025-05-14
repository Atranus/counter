package com.example.counter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityBisqareEquationBinding
import com.example.counter.databinding.ActivitySqareEquationBinding
import kotlin.math.sqrt

class BisqareEquation : AppCompatActivity() {

    private lateinit var binding: ActivityBisqareEquationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBisqareEquationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                val A = if (etA.text.isNotEmpty()) etA.text.toString().toFloat() else 1F
                val B = if (etB.text.isNotEmpty()) etB.text.toString().toFloat()  else 1F
                val y = if (etY.text.isNotEmpty()) etY.text.toString().toFloat()  else 0F
                val C = if (etC.text.isNotEmpty()) etC.text.toString().toFloat()  else 0F  - y

                val D = (B*B - 4*A*C)

                when {
                    (D > 0F) -> {
                        var ancwer =""

                        if ((((-B) + sqrt(D)) / (2 * A))>=0) {ancwer += "X1 = ${sqrt(((-B) + sqrt(D)) / (2 * A))}\n" + "X2 = ${-sqrt(((-B) + sqrt(D)) / (2 * A))}\n"}
                        if ((((-B) - sqrt(D)) / (2 * A))>=0) {ancwer += "X3 = ${sqrt(((-B) - sqrt(D)) / (2 * A))}\n" + "X4 = ${-sqrt(((-B) - sqrt(D)) / (2 * A))}"}

                        tvAnswer.text = ancwer
                    }
                    (D == 0F) -> if(((-B)) / (2 * A)>=0){
                        tvAnswer.text = "X1 = ${sqrt(((-B)) / (2 * A))}\nX2 = ${-sqrt(((-B)) / (2 * A))}"
                    }
                    (D < 0F) -> tvAnswer.text = "Корней нет"
                }
            }
        }
    }
}