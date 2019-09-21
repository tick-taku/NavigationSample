package com.jetpack.navigation.view.bike

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentSelectBikeMakerBinding
import com.jetpack.navigation.util.dataBinding

class SelectBikeMakerFragment: Fragment(R.layout.fragment_select_bike_maker) {

    private val binding: FragmentSelectBikeMakerBinding by dataBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.giant.setOnClickListener { transitToBikeDetails(BikeDefinition.GIANT) }
        binding.merida.setOnClickListener { transitToBikeDetails(BikeDefinition.MERIDA) }
        binding.colnago.setOnClickListener { transitToBikeDetails(BikeDefinition.COLNAGO) }
        binding.pinarello.setOnClickListener { transitToBikeDetails(BikeDefinition.PINARELLO) }
        binding.carrera.setOnClickListener { transitToBikeDetails(BikeDefinition.CARRERA) }
    }

    private fun transitToBikeDetails(definition: BikeDefinition) {
        findNavController().navigate(
            SelectBikeMakerFragmentDirections
                .selectToBike(context?.getString(definition.nameResId) ?: "")
                .setBikeDefinition(definition)
        )
    }

}