package com.example.capstone

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
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

        toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }

        destinationListener()
    }

    private fun destinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.WelcomeFragment)) {
                toolbar.title = "Welkom"
                bottom_navigation.setVisibility(View.GONE)
                toolbar.navigationIcon = null
            } else if (destination.id in arrayOf(R.id.PartsFragment)) {
                toolbar.title = "Selecteer Onderdelen"
                bottom_navigation.setVisibility(View.VISIBLE)
                toolbar.navigationIcon = null
            } else if (destination.id in arrayOf(R.id.InfoFragment)) {
                toolbar.title = "Info"
                bottom_navigation.setVisibility(View.VISIBLE)
                toolbar.navigationIcon = null
            } else if (destination.id in arrayOf(R.id.CartFragment)) {
                toolbar.title = "Winkelwagen"
                bottom_navigation.setVisibility(View.VISIBLE)
                toolbar.navigationIcon = null
            } else if (destination.id in arrayOf(R.id.IndividualPartFragment)) {
                toolbar.title = "Selecteer Onderdeel"
                bottom_navigation.setVisibility(View.GONE)
                toolbar.setNavigationIcon(R.drawable.arrow_back)
            } else if (destination.id in arrayOf(R.id.PaymentFragment)) {
                toolbar.title = "Afrekenen"
                bottom_navigation.setVisibility(View.GONE)
                toolbar.setNavigationIcon(R.drawable.arrow_back)
            } else if (destination.id in arrayOf(R.id.PaymentCompleteFragment)) {
                toolbar.title = "Betaling voltooid"
                bottom_navigation.setVisibility(View.GONE)
                toolbar.navigationIcon = null
            }
        }
    }
}