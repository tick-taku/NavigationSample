package com.jetpack.navigation.view.bike

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentBikeBinding
import com.jetpack.navigation.util.dataBinding

class BikeFragment: Fragment(R.layout.fragment_bike) {

    private val binding: FragmentBikeBinding by dataBinding()

    private val args: BikeFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.bikeImage.setImageResource(args.bikeDefinition.imageResId)
    }

}