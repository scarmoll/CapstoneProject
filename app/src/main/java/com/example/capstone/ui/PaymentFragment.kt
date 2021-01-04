package com.example.capstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        super.onViewCreated(view, savedInstanceState)
    }
}