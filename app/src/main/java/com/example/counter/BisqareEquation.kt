package com.example.counter

import android.os.Bundle
import android.view.View
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
                val A = if ((etA.text.isNotEmpty())) etA.text.toString().toFloat() else 1F
                val B = if (etB.text.isNotEmpty()) etB.text.toString().toFloat()  else 1F
                val y = if (etY.text.isNotEmpty()) etY.text.toString().toFloat()  else 0F
                val C = (if (etC.text.isNotEmpty()) etC.text.toString().toFloat()  else 0F) - y

                val D = (B*B - 4*A*C)

                x12.setVisibility(View.GONE)
                x12Side.setVisibility(View.GONE)
                x12Side.text = "---"
                x12Lable.text = "X₁₂² = "
                x34.setVisibility(View.GONE)
                x34Side.setVisibility(View.GONE)
                x34Side.text = "---"
                x34Lable.text = "X₃₄² = "
                x1.setVisibility(View.GONE)
                x1.text = "X₁ = "
                x2.setVisibility(View.GONE)
                x2.text = "X₂ = "
                x3.setVisibility(View.GONE)
                x3.text = "X₃ = "
                x4.setVisibility(View.GONE)
                x4.text = "X₄ = "
                d.setVisibility(View.GONE)
                tvAnswer.setVisibility(View.GONE)

                d.setVisibility(View.VISIBLE)
                dAnswer.text = " $B² - 4($A)($C) = $D"

                when {
                    (D > 0F) -> {
                        x12Up.text = "${(-B)} + ${sqrt(D)}"
                        x12Down.text = "${(2 * A)}"
                        x12Answer.text = " = ${((-B) + sqrt(D)) / (2 * A)}"
                        x12.setVisibility(View.VISIBLE)
                        x12Side.setVisibility(View.VISIBLE)

                        val X12 = ((-B) + sqrt(D)) / (2 * A)
                        when{
                            (X12 > 0F) -> {

                                x12Side.text = "      ┏\n => ┃\n      ┗"
                                x1.setVisibility(View.VISIBLE)
                                x1.text = "X₁ = ${sqrt(X12)}"
                                x2.setVisibility(View.VISIBLE)
                                x2.text = "X₂ = ${-sqrt(X12)}"
                            }
                            (X12 == 0F) -> {
                                x12Side.text = " => "
                                x1.setVisibility(View.VISIBLE)
                                x1.text = "X₁ = ${sqrt(X12)}"
                            }
                            (X12 < 0F) -> {
                                x12Side.text = " => ⌀"
                            }
                        }

                        x34Up.text = "${(-B)} - ${sqrt(D)}"
                        x34Down.text = "${(2 * A)}"
                        x34Answer.text = " = ${((-B) - sqrt(D)) / (2 * A)}"
                        x34.setVisibility(View.VISIBLE)
                        x34Side.setVisibility(View.VISIBLE)

                        val X34 = ((-B) - sqrt(D)) / (2 * A)
                        when{
                            (X34 > 0F) -> {
                                x34Side.text = "      ┏\n => ┃\n      ┗"
                                x3.setVisibility(View.VISIBLE)
                                x3.text = "X₃ = ${sqrt(X34)}"
                                x4.setVisibility(View.VISIBLE)
                                x4.text = "X₄ = ${-sqrt(X34)}"
                            }
                            (X34 == 0F) -> {
                                x34Side.text = " => "
                                x3.setVisibility(View.VISIBLE)
                                x3.text = "X₃ = ${sqrt(X34)}"
                            }
                            (X34 < 0F) -> {
                                x34Side.text = " => ⌀"
                            }
                        }
                    }
                    (D == 0F) -> {
                        x12Up.text = "${(-B)}"
                        x12Down.text = "${(2 * A)}"
                        x12Answer.text = " = ${(-B) / (2 * A)}"
                        x12.setVisibility(View.VISIBLE)
                        x12Side.setVisibility(View.VISIBLE)

                        val X12 = (-B) / (2 * A)
                        when{
                            (X12 > 0F) -> {
                                x1.setVisibility(View.VISIBLE)
                                x1.text = "X₁ = ${sqrt(X12)}"
                                x2.setVisibility(View.VISIBLE)
                                x2.text = "X₂ = ${-sqrt(X12)}"
                            }
                            (X12 == 0F) -> {
                                x12Side.text = " => "
                                x1.text = "X₁ = ${sqrt(X12)}"
                            }
                            (X12 < 0F) -> {
                                x12Side.text = " => ⌀"
                            }
                        }
                    }
                    (D < 0F) -> {
                        tvAnswer.setVisibility(View.VISIBLE)
                        tvAnswer.text = "Корней нет"
                    }
                }
                if (((x12Side.text == " => ⌀") && (x34Side.text == " => ⌀")) or
                    ((x12Side.text == "---") && (x34Side.text == " => ⌀")) or
                    ((x12Side.text == " => ⌀") && (x34Side.text == "---")))
                {
                    tvAnswer.setVisibility(View.VISIBLE)
                    tvAnswer.text = "Корней нет"
                }

                if (A == 0F){
                    x12.setVisibility(View.GONE)
                    x34.setVisibility(View.GONE)
                    d.setVisibility(View.GONE)
                    tvAnswer.text = "А ≠ 0"
                    tvAnswer.setVisibility(View.VISIBLE)
                }
            }
        }
    }
}