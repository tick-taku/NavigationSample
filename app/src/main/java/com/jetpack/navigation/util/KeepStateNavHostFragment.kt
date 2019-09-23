package com.jetpack.navigation.util

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign

class KeepStateNavHostFragment: NavHostFragment() {

    override fun onCreateNavController(navController: NavController) {
        super.onCreateNavController(navController)
        navController.navigatorProvider += KeepStateNavigator(requireContext(), childFragmentManager, id)
    }

}