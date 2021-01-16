package com.example.capstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.capstone.R
import kotlinx.android.synthetic.main.fragment_payment_complete.*
import org.json.JSONException
import org.json.JSONObject

class PaymentCompleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val intent = activity?.intent

        try {
            val jsonObject = JSONObject(intent?.getStringExtra("PaymentDetails"))
            showDetails(
                jsonObject.getJSONObject("response"),
                intent?.getStringExtra("PaymentAmount")
            )
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        btnReturnHome.setOnClickListener {
            view.findNavController().navigate(R.id.PartsFragment)

        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun showDetails(response: JSONObject, paymentAmount: String?) {
        tvId.text = response.getString("id")
        tvStatus.text = response.getString("state")
        tvAmount.text = response.getString(String.format("€%s", paymentAmount))
    }
}