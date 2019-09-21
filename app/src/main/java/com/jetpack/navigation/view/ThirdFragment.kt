package com.jetpack.navigation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentThirdBinding
import com.jetpack.navigation.util.dataBinding

class ThirdFragment: Fragment(R.layout.fragment_third) {

    private val binding: FragmentThirdBinding by dataBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.prev.setOnClickListener {
            findNavController().navigate(ThirdFragmentDirections.thirdToFirst())
        }
    }

}