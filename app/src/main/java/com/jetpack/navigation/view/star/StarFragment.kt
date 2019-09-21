package com.jetpack.navigation.view.star

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentStarBinding
import com.jetpack.navigation.util.dataBinding

class StarFragment: Fragment(R.layout.fragment_star) {

    private val binding: FragmentStarBinding by dataBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.sirius.setOnClickListener { showImage(R.drawable.sirius) }
        binding.spica.setOnClickListener { showImage(R.drawable.spica) }
        binding.albireo.setOnClickListener { showImage(R.drawable.albireo) }
    }

    private fun showImage(@DrawableRes id: Int) {
        findNavController().navigate(StarFragmentDirections.selectToImage(id))
    }

}