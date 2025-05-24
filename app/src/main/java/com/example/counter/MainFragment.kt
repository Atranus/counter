package com.example.counter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.counter.MainActivity
import com.example.counter.databinding.FragmentMainBinding
import com.example.counter.posobility.PosobBinomP
import com.example.counter.posobility.PosobGeomP
import com.example.counter.posobility.PosobPuassP

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(binding){
            btnSqareEquation.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_sqareEquation)
            }
            btnBisqareEquation.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_bisqareEquation)
            }
            btnModul.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_modul)
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
                findNavController().navigate(R.id.action_mainFragment_to_posobBinomP)
            }
            btnPosobGeom.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_posobGeomP)
            }
            btnPosobPuass.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_posobPuassP)
            }
        }

        return binding.root
    }

}