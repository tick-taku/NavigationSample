package com.jetpack.navigation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jetpack.navigation.databinding.ActivityMainBinding
import com.jetpack.navigation.util.dataBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by dataBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()

        setupBottomNavigation()
    }

    //------------------------------------------------------------------------------------------------------------------
    // MARK: Toolbar
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Setup toolbar
     */
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))

        if (Build.VERSION_CODES.M <= Build.VERSION.SDK_INT) {
            binding.root.apply {
                systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }
    }

    /**
     * Setup for BottomNavigationView
     */
    private fun setupBottomNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigation.setupWithNavController(navController)
    }

}
