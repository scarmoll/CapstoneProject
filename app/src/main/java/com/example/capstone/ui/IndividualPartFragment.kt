package com.example.capstone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.model.IndividualPart
import com.example.capstone.adapters.IndividualPartAdapter
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_individual_parts.*

class IndividualPartFragment : Fragment() {

    val args: IndividualPartFragmentArgs by navArgs()

    private val individualPartList = arrayListOf<IndividualPart>()
    private val individualPartListAdapter =
        IndividualPartAdapter(individualPartList) { individualPart: IndividualPart ->
            itemClicked(individualPart)
        }
    private val viewModel: CartViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individual_parts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val position = args.partPosition

        super.onViewCreated(view, savedInstanceState)

        initViews(position)
    }

    private fun itemClicked(individualPart: IndividualPart) {
        viewModel.insertPart(individualPart)
    }

    private fun initViews(position: Int) {
        rvIndividualPartsList.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvIndividualPartsList.adapter = individualPartListAdapter

        when (position) {
            0 -> {
                individualPartList.addAll(
                    IndividualPart.STRAPS
                )
            }

            1 -> {
                individualPartList.addAll(
                    IndividualPart.BEZELS
                )
            }

            2 -> {
                individualPartList.addAll(
                    IndividualPart.INSERTS
                )
            }

            3 -> {
                individualPartList.addAll(
                    IndividualPart.CHAPTER_RINGS
                )
            }

            4 -> {
                individualPartList.addAll(
                    IndividualPart.GLASS
                )
            }

            5 -> {
                individualPartList.addAll(
                    IndividualPart.CROWNS
                )
            }

            6 -> {
                individualPartList.addAll(
                    IndividualPart.CASES
                )
            }

            7 -> {
                individualPartList.addAll(
                    IndividualPart.DIALS
                )
            }

            8 -> {
                individualPartList.addAll(
                    IndividualPart.HANDS
                )
            }
        }

        individualPartListAdapter.notifyDataSetChanged()
    }
}