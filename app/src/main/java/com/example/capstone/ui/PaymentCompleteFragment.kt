package com.example.capstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.capstone.R
import kotlinx.android.synthetic.main.fragment_payment_complete.*

class PaymentCompleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnReturnHome.setOnClickListener {
            view.findNavController().navigate(R.id.PartsFragment)

        }

        super.onViewCreated(view, savedInstanceState)
    }
}