package com.example.capstone.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.capstone.MainActivity
import com.example.capstone.R
import com.example.capstone.config.Config
import com.example.capstone.viewmodel.CartViewModel
import com.paypal.android.sdk.payments.*
import kotlinx.android.synthetic.main.fragment_payment.*
import java.math.BigDecimal

class PaymentFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()
    val args: PaymentFragmentArgs by navArgs()

    val PAYPAL_REQUEST_CODE = 7171

    val config = PayPalConfiguration()
        .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
        .clientId(Config().PAYPAL_CLIENT_ID)

//    private val amount = args.totalPrice.split(" ")[1].toDouble()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val duration = Toast.LENGTH_SHORT
        tvPaymentTotal.text = args.totalPrice

        val intent = Intent(context, PayPalService::class.java)
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        context?.startService(intent)

        paymentFAB.setOnClickListener {
            viewModel.clearCart()
            view.findNavController().navigate(R.id.PaymentCompleteFragment)
        }

        btnAbnAmro.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft ABN Amro geselecteerd", duration)
            toast.show()
        }

        btnIng.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft ING geselecteerd", duration)
            toast.show()
        }

        btnPayPal.setOnClickListener {
            processPayment()
        }

//        btnPayPal.setOnClickListener {
//            val toast = Toast.makeText(context, "U heeft PayPal geselecteerd", duration)
//            toast.show()
//        }

        btnRabobank.setOnClickListener {
            val toast = Toast.makeText(context, "U heeft Rabobank geselecteerd", duration)
            toast.show()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        context?.stopService(Intent(context, PayPalService::class.java))
        super.onDestroy()
    }

    private fun processPayment() {
        val amount = args.totalPrice.split(" ")[1].toDouble()

        val payPalPayment = PayPalPayment(
            BigDecimal(amount),
            "EUR",
            "Pay for order",
            PayPalPayment.PAYMENT_INTENT_SALE
        )

        val intent = Intent(context, PaymentActivity::class.java)

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment)

        startActivityForResult(intent, PAYPAL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val amount = args.totalPrice.split(" ")[1].toDouble()

        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val confirmation =
                    data?.getParcelableExtra<PaymentConfirmation>(PaymentActivity.EXTRA_RESULT_CONFIRMATION)

                if (confirmation != null) {
                    val paymentDetails = confirmation.toJSONObject().toString(4)

                    startActivity(
                        Intent(context, MainActivity::class.java)
                            .putExtra("PaymentDetails", paymentDetails)
                            .putExtra("PaymentAmount", amount)
                    )
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            }
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Toast.makeText(context, "Invalid", Toast.LENGTH_SHORT).show()
        }
    }
}