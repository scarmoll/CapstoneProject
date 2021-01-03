package com.example.capstone.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import kotlinx.android.synthetic.main.item_cart_item.view.*

class CartAdapter(
    private val gameList: List<IndividualPart>,
    private val clickListener: (IndividualPart) -> Unit
) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun databind(individualPart: IndividualPart) {
            itemView.tvCartItemName.text = individualPart.name
            itemView.tvCartItemPrice.text = individualPart.price.toString()

            itemView.btnDeleteFromCart.setOnClickListener(View.OnClickListener {
                clickListener(
                    individualPart
                )
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart_item, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.databind(gameList[position])
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}