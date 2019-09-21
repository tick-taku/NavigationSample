package com.jetpack.navigation.view.bike

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jetpack.navigation.R

enum class BikeDefinition(@StringRes val nameResId: Int, @DrawableRes val imageResId: Int) {
    GIANT(R.string.bike_maker_giant, R.drawable.giant),
    MERIDA(R.string.bike_maker_merida, R.drawable.merida),
    COLNAGO(R.string.bike_maker_colnago, R.drawable.colnago),
    PINARELLO(R.string.bike_maker_pinarello, R.drawable.pinarello),
    CARRERA(R.string.bike_maker_carrera, R.drawable.carrera)
}