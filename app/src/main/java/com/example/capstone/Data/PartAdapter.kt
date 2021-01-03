package com.example.capstone.Data

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import kotlinx.android.synthetic.main.item_part.view.*


class PartAdapter(private val part: List<Part>) :
    RecyclerView.Adapter<PartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(part: Part) {
            itemView.tvPartName.text = part.name
            itemView.tvDescription.text = part.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_part, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener(View.OnClickListener { view ->
            view.findNavController().navigate(R.id.IndividualPartFragment)
        })

        holder.databind(part[position])
    }

    override fun getItemCount(): Int {
        return part.size
    }

}