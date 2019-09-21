package com.jetpack.navigation.util

import android.annotation.SuppressLint
import androidx.core.view.forEach
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

object BottomNavigationViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("disableShiftMode")
    @SuppressLint("RestrictedApi")
    fun BottomNavigationView.setDisableShiftMode(isDisable: Boolean) {
        if (!isDisable) return

        val menuView = getChildAt(0) as BottomNavigationMenuView

        // Disable label
        menuView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
        menuView.forEach {
            (it as BottomNavigationItemView).apply {
                // Reflect icon color
                setIconTintList(null)
                // Disable first item label
                setChecked(false)
            }
        }
    }

}