package com.jetpack.navigation.view.number

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentSecondBinding
import com.jetpack.navigation.util.dataBinding

class SecondFragment: Fragment(R.layout.fragment_second) {

    private val binding: FragmentSecondBinding by dataBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.next.setOnClickListener {
//            findNavController().navigate(SecondFragmentDirections.secondToThird())
        }
    }

}