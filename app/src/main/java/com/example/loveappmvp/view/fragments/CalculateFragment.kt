package com.example.loveappmvp.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loveappmvp.model.ApiConstants
import com.example.loveappmvp.model.CalculateResult
import com.example.loveappmvp.model.RetrofitInstance
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment() {

    private val binding by lazy {
        FragmentCalculateBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOnClickListeners()
    }
    private fun setUpOnClickListeners() = with(binding) {
        btnCalculate.setOnClickListener {
            Log.d("Debug", "Button clicked")
            RetrofitInstance.api.getPercentage(
                firstName = etFirstName.text.toString(),
                secondName = etSecondName.text.toString(),
                key = ApiConstants.KEY,
                host = ApiConstants.HOST
            ).enqueue(object : Callback<CalculateResult> {
                override fun onResponse(call: Call<CalculateResult>, response: Response<CalculateResult>) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d("Debug", "API request successful: ${response.body()}")
                        val action = CalculateFragmentDirections.actionCalculateToResultFragment(response.body()!!)
                        binding.etFirstName.text.clear()
                        binding.etSecondName.text.clear()
                        findNavController().navigate(action)
                    } else {
                        Log.e("Error", "API response failed: ${response.code()}")
                        Toast.makeText(requireContext(), "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<CalculateResult>, t: Throwable) {
                    Log.e("Error", "API request failed: ${t.localizedMessage}")
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}