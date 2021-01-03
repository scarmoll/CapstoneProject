package com.example.capstone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.Data.CartAdapter
import com.example.capstone.Data.IndividualPart
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    private val cartItemList = arrayListOf<IndividualPart>()
    private val cartItemListAdapter = CartAdapter(cartItemList)
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

        initViews()
        observeCart()
    }

    private fun observeCart() {
        viewModel.cart.observe(viewLifecycleOwner, Observer { cart ->
            this@CartFragment.cartItemList.clear()
            this@CartFragment.cartItemList.addAll(cart)
            cartItemListAdapter.notifyDataSetChanged()
        })
    }

    fun initViews() {
        rvCartItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvCartItems.adapter = cartItemListAdapter
    }
}