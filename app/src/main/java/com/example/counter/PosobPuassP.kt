package com.example.counter

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityPosobBinomPBinding
import com.example.counter.databinding.ActivityPosobPuassPBinding
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sqrt

class PosobPuassP : AppCompatActivity() {

    fun factorial(num: Int): Long {
        var result = 1L
        for (i in 2..num) result *= i
        return result
    }

    private lateinit var binding: ActivityPosobPuassPBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPosobPuassPBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                llLmbda.setVisibility(View.GONE)
                llP.setVisibility(View.GONE)
                llD.setVisibility(View.GONE)
                llM.setVisibility(View.GONE)
                llSigm.setVisibility(View.GONE)

                val n = if (etN.text.isNotEmpty()) etN.text.toString().toInt() else 1
                val k = if (etK.text.isNotEmpty() or (etK.text.toString().toInt() > n)) etK.text.toString().toInt() else 1
                val p = if (etPlittle.text.isNotEmpty()) etPlittle.text.toString().toFloat() else 0.5F

                val lambda = n*p

                tvLambdaResult.text = "$n · $p = $lambda"

                tvPN.text = "$n"
                tvPK.text = "$k"

                tvPUpLambda.text = "$lambda"
                tvPUpK.text = "$k"
                tvPDownK.text = "$k!"

                tvPELambda.text = "$lambda"

                tvPResult.text = " = ${(lambda.pow(k))/(factorial(k))*(exp(-lambda))}"

                tvM.text = "$n · $p = ${n*p}"

                tvD.text = "$n · $p · ${1-p} = ${n*p*(1-p)}"

                tvSigmDx.text = "${n*p*(1-p)}"
                tvSigmAnswer.text = " = ${sqrt((n*p*(1-p)))}"

                tvM.text = "$lambda"

                tvD.text = "$lambda"

                tvSigmDx.text = "$lambda"
                tvSigmAnswer.text = " = ${sqrt(lambda)}"

                llLmbda.setVisibility(View.VISIBLE)
                llP.setVisibility(View.VISIBLE)
                llD.setVisibility(View.VISIBLE)
                llM.setVisibility(View.VISIBLE)
                llSigm.setVisibility(View.VISIBLE)
            }
        }

    }
}