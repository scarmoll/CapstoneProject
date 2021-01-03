package com.example.capstone.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import kotlinx.android.synthetic.main.item_individual_part.view.*


class IndividualPartAdapter(private val individualPart: List<IndividualPart>) :
    RecyclerView.Adapter<IndividualPartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(individualPart: IndividualPart) {
            itemView.tvIndividualPartName.text = individualPart.name
            itemView.tvIndividualPrice.text = individualPart.price.toString()
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

        val name = holder.itemView.tvIndividualPartName.text.toString()
        val price = holder.itemView.tvIndividualPrice.text.toString()

        holder.databind(individualPart[position])
    }

    override fun getItemCount(): Int {
        return individualPart.size
    }

}