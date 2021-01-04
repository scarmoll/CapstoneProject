package com.example.capstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_payment.*

class PaymentFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        paymentFAB.setOnClickListener {
            viewModel.clearCart()
            view.findNavController().navigate(R.id.PaymentCompleteFragment)
        }

        val duration = Toast.LENGTH_SHORT

        btnAbnAmro.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft ABN Amro geselecteerd", duration)
            toast.show()
        }

        btnIng.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft ING geselecteerd", duration)
            toast.show()
        }

        btnPayPal.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft PayPal geselecteerd", duration)
            toast.show()
        }

        btnRabobank.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft Rabobank geselecteerd", duration)
            toast.show()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}