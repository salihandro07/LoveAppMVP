package com.example.loveappmvp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.loveappmvp.model.CalculateResult
import com.example.lovecalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private val binding by lazy { FragmentResultBinding.inflate(layoutInflater) }
    private lateinit var calculatedResult: CalculateResult
    private val safeArgs: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calculatedResult = safeArgs.calculateResult!!
        displayResult()
    }
    private fun displayResult() {
        binding.tvFirstName.text = calculatedResult.firstName
        binding.tvSecondName.text = calculatedResult.secondName
        binding.tvPercentage.text = "Compatibility: ${calculatedResult.percentage}%"
        binding.tvLoveResult.text = calculatedResult.result
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}