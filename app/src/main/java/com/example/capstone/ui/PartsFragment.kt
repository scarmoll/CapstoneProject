package com.example.capstone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.model.Part
import com.example.capstone.adapters.PartAdapter
import com.example.capstone.R
import kotlinx.android.synthetic.main.fragment_parts.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PartsFragment : Fragment() {

    private val partList = arrayListOf<Part>()
    private val partListAdapter = PartAdapter(partList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    fun initViews() {
        rvPartsList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvPartsList.adapter = partListAdapter

        partList.clear()

        for (i in Part.PART_NAME.indices) {
            partList.add(Part(Part.PART_NAME[i], Part.PART_DESCRIPTION[i]))
        }

        partListAdapter.notifyDataSetChanged()
    }
}