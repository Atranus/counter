package com.example.counter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityModulBinding
import com.example.counter.databinding.ActivityPosobBinomPBinding
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sqrt

class PosobBinomP : AppCompatActivity() {

    fun factorial(num: Int): Long {
        var result = 1L
        for (i in 2..num) {
            result *= i

            Log.i("Число", result.toString())
        }
        return result
    }

    private lateinit var binding: ActivityPosobBinomPBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPosobBinomPBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                llC.setVisibility(View.GONE)
                llP.setVisibility(View.GONE)
                llD.setVisibility(View.GONE)
                llM.setVisibility(View.GONE)
                llSigm.setVisibility(View.GONE)

                val n = if (etN.text.isNotEmpty()) etN.text.toString().toInt() else 1
                val k = if (etK.text.isNotEmpty() or (etK.text.toString().toInt() < n)) etK.text.toString().toInt() else 1
                val p = if (etPlittle.text.isNotEmpty()) etPlittle.text.toString().toFloat() else 0.5F

                tvCM.text = "$k"
                tvCN.text = "$n"

                tvCUp.text = "$n!"
                tvCDown.text = "$k!($n-$k)!"

                val C = factorial(n) /(factorial(k)*factorial(n-k))

                tvCResult.text = " = $C"

                tvPN.text = "$n"
                tvPK.text = "$k"

                tvPcM.text = "$k"
                tvPcN.text = "$n"

                tvPP.text = "$p"
                tvPPK.text = "$k"
                tvPQ.text = "${1-p}"
                tvPQNk.text = "${n-k}"

                tvPResult.text = " = ${C*(p.pow(k.toFloat()))*((1F-p).pow((n-k).toFloat()))}"

                tvM.text = "$n · $p = ${n*p}"

                tvD.text = "$n · $p · ${1-p} = ${n*p*(1-p)}"

                tvSigmDx.text = "${n*p*(1-p)}"
                tvSigmAnswer.text = " = ${sqrt((n*p*(1-p)))}"

                llC.setVisibility(View.VISIBLE)
                llP.setVisibility(View.VISIBLE)
                llD.setVisibility(View.VISIBLE)
                llM.setVisibility(View.VISIBLE)
                llSigm.setVisibility(View.VISIBLE)
            }
        }

    }
}