package com.example.capstone.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.capstone.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = context?.getSharedPreferences("PREF", Context.MODE_PRIVATE)

        // Wipes shared preferences, for demo purposes
//        sharedPref?.edit()?.clear()?.apply()

        if (sharedPref?.getBoolean("prevStart", false)!!) {
            findNavController().navigate(R.id.action_WelcomeFragment_to_PartsFragment)
        } else {
            sharedPref.edit()?.putBoolean("prevStart", true)?.apply()
        }

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_WelcomeFragment_to_PartsFragment)
        }
    }
}