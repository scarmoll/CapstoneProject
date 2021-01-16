package com.example.capstone.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_payment_complete.*
import org.json.JSONObject

class PaymentCompleteFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()
    val args: PaymentCompleteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showDetails(JSONObject(args.paymentDetails).getJSONObject("response"), args.payedAmount)

        if (JSONObject(args.paymentDetails).getJSONObject("response").getString("state") == "approved") {
            viewModel.clearCart()
        }

        btnReturnHome.setOnClickListener {
            view.findNavController().navigate(R.id.PartsFragment)

        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun showDetails(response: JSONObject, paymentAmount: String?) {
//        tvId.text = response.getString("id")
//        tvStatus.text = response.getString("state")
//        tvAmount.text = String.format("€%s", paymentAmount)

        Log.i("payment_log", "Payment ID: ${response.getString("id")}")
        Log.i("payment_log", "Payment Status: ${response.getString("state")}")
        Log.i(
            "payment_log", "Total: ${String.format("€%s", paymentAmount)}"
        )
    }
}