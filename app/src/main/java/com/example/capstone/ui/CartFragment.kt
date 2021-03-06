package com.example.capstone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.adapters.CartAdapter
import com.example.capstone.model.IndividualPart
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    private val cartItemList = arrayListOf<IndividualPart>()
    private val cartItemListAdapter = CartAdapter(cartItemList) { individualPart: IndividualPart ->
        itemClicked(individualPart)
    }
    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cartFab.setOnClickListener {
            if (!isCartEmpty()) {
                val action = CartFragmentDirections.actionCartFragmentToPaymentFragment(
                    "€ ${
                        "%.2f".format(
                            getCartTotal()
                        )
                    }"
                )

                view.findNavController().navigate(action)
            } else {
                val text = "Cart cannot be empty!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
        }

        initViews()
        observeCart()
    }

    private fun itemClicked(individualPart: IndividualPart) {
        viewModel.deletePart(individualPart)
    }

    private fun observeCart() {
        viewModel.cart.observe(viewLifecycleOwner, Observer { cart ->
            this@CartFragment.cartItemList.clear()
            this@CartFragment.cartItemList.addAll(cart)
            cartItemListAdapter.notifyDataSetChanged()

            var total = 0.0

            for (item in cartItemList) {
                total += item.price
            }

            tvCartTotal.text = "€ ${"%.2f".format(total).toString()}"
        })
    }

    private fun isCartEmpty(): Boolean {
        return cartItemListAdapter.itemCount == 0
    }

    private fun getCartTotal(): Double {
        var total = 0.0
        viewModel.cart.observe(viewLifecycleOwner, Observer { cart ->

            for (item in cartItemList) {
                total += item.price
            }

        })
        return total
    }

    fun initViews() {
        rvCartItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvCartItems.adapter = cartItemListAdapter
    }
}