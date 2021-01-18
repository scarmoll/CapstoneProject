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
                populateIndividualList(IndividualPart.STRAP_NAME, IndividualPart.STRAP_PRICE, IndividualPart.STRAP_RES_DRAWABLE_IDS)
            }

            1 -> {
                populateIndividualList(IndividualPart.BEZEL_NAME, IndividualPart.BEZEL_PRICE, IndividualPart.BEZEL_RES_DRAWABLE_IDS)
            }

            2 -> {
                populateIndividualList(IndividualPart.INSERT_NAME, IndividualPart.INSERT_PRICE, IndividualPart.INSERT_RES_DRAWABLE_IDS)
            }

            3 -> {
                populateIndividualList(IndividualPart.CHAPTER_RING_NAME, IndividualPart.CHAPTER_RING_PRICE, IndividualPart.CHAPTER_RING_RES_DRAWABLE_IDS)
            }

            4 -> {
                populateIndividualList(IndividualPart.GLASS_NAME, IndividualPart.GLASS_PRICE, IndividualPart.GLASS_RING_RES_DRAWABLE_IDS)
            }

            5 -> {
                populateIndividualList(IndividualPart.CROWN_NAME, IndividualPart.CROWN_PRICE, IndividualPart.CROWN_RES_DRAWABLE_IDS)
            }

            6 -> {
                populateIndividualList(IndividualPart.CASE_NAME, IndividualPart.CASE_PRICE, IndividualPart.CASE_RES_DRAWABLE_IDS)
            }

            7 -> {
                populateIndividualList(IndividualPart.DIAL_NAME, IndividualPart.DIAL_PRICE, IndividualPart.DIAL_RES_DRAWABLE_IDS)
            }

            8 -> {
                populateIndividualList(IndividualPart.HANDS_NAME, IndividualPart.HANDS_PRICE, IndividualPart.HANDS_RES_DRAWABLE_IDS)
            }
        }

        individualPartListAdapter.notifyDataSetChanged()
    }

    private fun populateIndividualList(
        partName: Array<String>,
        partPrice: Array<Double>,
        partResDrawableIds: Array<Int>
    ) {
        for (i in partName.indices) {
            individualPartList.add(
                IndividualPart(
                    partName[i],
                    partPrice[i],
                    partResDrawableIds[i]
                )
            )
        }
    }
}