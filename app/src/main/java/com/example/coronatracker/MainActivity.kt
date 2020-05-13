package com.example.coronatracker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.coronatracker.workmanager.WorkerViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var navHostFragment: NavHostFragment? = null
    companion object {
        const val SHARED_PREFERENCE = "coronaSharedPreferences"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*sara*/
        setupNavigation()
        /*sara*/
        /*ahemd*/
        /*ahmed*/

        if (!isWorkManagerRunning()) {
            Log.i("ahmed", "not running")
            val workManager = WorkerViewModel(this)
            workManager.requestNewData(2, TimeUnit.HOURS)

            val editor = getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE).edit()
            editor.putBoolean("workManager", true)
            editor.apply()
        }
    }
    /*sara*/
    fun  setupNavigation()
    {
        val navView: BottomNavigationView = nav_view
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            navView,
            navHostFragment!!.navController
        )
        navHostFragment?.getNavController()?.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.countryStatisticFragment)
            {
                navView.visibility = View.GONE
            }
            else
            {
                navView.visibility = View.VISIBLE
            }
        }

}

    private fun isWorkManagerRunning(): Boolean {
        val preferences = getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getBoolean("workManager", false)
    }

    /*sara*/
    /*ahmed*/
    /*ahmed*/
}
