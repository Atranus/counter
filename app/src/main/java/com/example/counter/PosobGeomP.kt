package com.example.counter

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.counter.databinding.ActivityPosobBinomPBinding
import com.example.counter.databinding.ActivityPosobGeomPBinding
import kotlin.math.pow
import kotlin.math.sqrt

class PosobGeomP : AppCompatActivity() {

    private lateinit var binding: ActivityPosobGeomPBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPosobGeomPBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btAnswer.setOnClickListener {
                llP.setVisibility(View.GONE)
                llD.setVisibility(View.GONE)
                llM.setVisibility(View.GONE)
                llSigm.setVisibility(View.GONE)
                tvAnswer.setVisibility(View.GONE)

                val n = if (etN.text.isNotEmpty()) etN.text.toString().toInt() else 1
                val k = if (etK.text.isNotEmpty()) {
                    if (etK.text.toString().toInt() < n) {
                        etK.text.toString().toInt()
                    }
                    else 1
                }
                else 1
                val p = if (etPlittle.text.isNotEmpty()) etPlittle.text.toString().toFloat() else 0.5F

                tvPN.text = "$n"
                tvPK.text = "$k"

                tvPP.text = "$p"
                tvPQ.text = "${1F-p}"
                tvPQK.text = "${k-1}"

                tvPResult.text = " = ${p*((1-p).pow((k-1).toFloat()))}"

                tvMP.text = "$p"
                tvM.text = " = ${1/p}"

                tvDQ.text = "${(1-p)}"
                tvDP.text = "$p²"
                tvD.text = " = ${(1-p)/(p*p)}"

                tvSigmDx.text = "${(1-p)/(p*p)}"
                tvSigmAnswer.text = " = ${sqrt(((1-p)/(p*p)))}"

                llP.setVisibility(View.VISIBLE)
                llD.setVisibility(View.VISIBLE)
                llM.setVisibility(View.VISIBLE)
                llSigm.setVisibility(View.VISIBLE)

                if (!((p > 0F) && (p < 1F))){
                    llP.setVisibility(View.GONE)
                    llD.setVisibility(View.GONE)
                    llM.setVisibility(View.GONE)
                    llSigm.setVisibility(View.GONE)
                    tvAnswer.text = "p принимает только значения от 0 до 1"
                    tvAnswer.setVisibility(View.VISIBLE)
                }
            }
        }
    }
}