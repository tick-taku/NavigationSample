package com.jetpack.navigation.view.star

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jetpack.navigation.R
import com.jetpack.navigation.databinding.FragmentStarImageBinding

class StarImageFragment: BottomSheetDialogFragment() {

    private lateinit var binding: FragmentStarImageBinding

    private val args: StarImageFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_star_image, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.starImage.setImageResource(args.image)
    }

}