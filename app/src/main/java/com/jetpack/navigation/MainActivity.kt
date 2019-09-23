package com.jetpack.navigation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jetpack.navigation.databinding.ActivityMainBinding
import com.jetpack.navigation.util.dataBinding
import com.jetpack.navigation.util.setupWithNavController
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by dataBinding()

    private val topLevelScreen = setOf(R.id.first_fragment,
                                       R.id.select_maker_fragment,
                                       R.id.star_fragment)

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
        val navGraph = listOf(R.navigation.number_graph,
                              R.navigation.bike_graph,
                              R.navigation.star_graph)
        binding.bottomNavigation
            .setupWithNavController(navGraph, supportFragmentManager, R.id.nav_host_fragment, intent)
            .observe(this) {
                // Bind toolbar for navigation
                setupActionBarWithNavController(it, AppBarConfiguration(topLevelScreen))
            }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()

}
