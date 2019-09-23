package com.jetpack.navigation.view.number

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentFirstBinding
import com.jetpack.navigation.util.dataBinding

class FirstFragment: Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by dataBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.next.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.firstToSecond())
        }
    }

}