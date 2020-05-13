package com.example.coronatracker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.coronatracker.workmanager.WorkerViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import java.nio.file.Files.delete


class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    var navHostFragment: NavHostFragment? = null
    companion object {
        const val SHARED_PREFERENCE = "coronaSharedPreferences"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*sara*/
        setupNavigation()
        menuItembtn.setOnClickListener {
            val popup = PopupMenu(this, it)
            popup.setOnMenuItemClickListener(this);
            val inflater: MenuInflater = popup.getMenuInflater()
            inflater.inflate(R.menu.hours_menu, popup.getMenu())

            popup.show()
        }
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

    override fun onMenuItemClick(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return when (id) {
            R.id.one_hour -> {
                Toast.makeText(applicationContext, "one_hour", Toast.LENGTH_LONG).show()
                true
            }
            R.id.two_hour -> {
                Toast.makeText(applicationContext, "two_hours", Toast.LENGTH_LONG).show()
                true
            }
            R.id.three_hours -> {
                Toast.makeText(applicationContext, "three_hours", Toast.LENGTH_LONG).show()
                true
            }
            R.id.one_day -> {
                Toast.makeText(applicationContext, "one_day", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    /*sara*/
    /*ahmed*/
    /*ahmed*/
}
