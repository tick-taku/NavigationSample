package com.jetpack.navigation.view

import androidx.fragment.app.Fragment
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentFirstBinding
import com.jetpack.navigation.util.dataBinding

class FirstFragment: Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by dataBinding()

}