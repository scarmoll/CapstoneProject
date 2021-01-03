package com.example.capstone

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        navController = findNavController(R.id.nav_host_fragment)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    navController.navigate(
                        R.id.PartsFragment
                    )
                    true
                }

                R.id.page_2 -> {
                    navController.navigate(
                        R.id.CartFragment
                    )
                    true
                }

                R.id.page_3 -> {
                    navController.navigate(
                        R.id.InfoFragment
                    )
                    true
                }

                else -> false
            }
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        destinationListener()
    }

    private fun destinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.WelcomeFragment)) {
                toolbar.title = "Welkom"
                bottom_navigation.setVisibility(View.GONE)
                fab.hide()
            } else if (destination.id in arrayOf(R.id.PartsFragment)) {
                toolbar.title = "Selecteer Onderdelen"
                bottom_navigation.setVisibility(View.VISIBLE)
                fab.hide()
            } else if (destination.id in arrayOf(R.id.InfoFragment)) {
                toolbar.title = "Info"
                fab.hide()
            } else if (destination.id in arrayOf(R.id.CartFragment)) {
                toolbar.title = "Winkelwagen"
                fab.show()
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}