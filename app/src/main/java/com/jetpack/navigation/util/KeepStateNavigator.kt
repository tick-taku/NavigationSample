package com.jetpack.navigation.util

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("keep_state_fragment")
class KeepStateNavigator(private val context: Context,
                         private val manager: FragmentManager,
                         private val containerId: Int)
    : FragmentNavigator(context, manager, containerId) {

    override fun navigate(destination: Destination,
                          args: Bundle?,
                          navOptions: NavOptions?,
                          navigatorExtras: Navigator.Extras?): NavDestination? {
        if (manager.isStateSaved) {
            return null
        }

        var className = destination.className
        if (className[0] == '.') {
            className = context.packageName + className
        }

        val tag = destination.id.toString()
        val transaction = manager.beginTransaction()

        val currentFragment = manager.primaryNavigationFragment
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        var fragment = manager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = manager.fragmentFactory.instantiate(context.classLoader, className)
            transaction.add(containerId, fragment, tag)
        }
        fragment.arguments = args

        transaction.show(fragment)
        transaction.setPrimaryNavigationFragment(fragment)
        transaction.commit()

        return destination
    }
}