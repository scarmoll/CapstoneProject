package com.example.capstone.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import kotlinx.android.synthetic.main.item_cart_item.view.*
import kotlinx.android.synthetic.main.item_individual_part.view.*


class IndividualPartAdapter(
    private val individualPart: List<IndividualPart>,
    private val clickListener: (IndividualPart) -> Unit
) :
    RecyclerView.Adapter<IndividualPartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(individualPart: IndividualPart) {
            itemView.tvIndividualPartName.text = individualPart.name
            itemView.tvIndividualPrice.text = individualPart.price.toString()

            itemView.setOnClickListener(View.OnClickListener {
                clickListener(
                    individualPart
                )
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_individual_part, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(individualPart[position])
    }

    override fun getItemCount(): Int {
        return individualPart.size
    }

}