package com.example.coronatracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*sara*/
        setupNavigation()
        /*sara*/
        /*ahemd*/
        /*ahmed*/
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
    }

    /*sara*/
    /*ahmed*/
    /*ahmed*/
}
