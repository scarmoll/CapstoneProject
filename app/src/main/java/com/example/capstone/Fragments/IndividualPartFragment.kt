package com.example.capstone.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.example.capstone.R

class IndividualPartFragment : Fragment() {

    val args: IndividualPartFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individual_part, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val tv: TextView = view.findViewById(R.id.tvTest)
        val position = args.partPosition
        tv.text = "index: $position"

        super.onViewCreated(view, savedInstanceState)
    }
}