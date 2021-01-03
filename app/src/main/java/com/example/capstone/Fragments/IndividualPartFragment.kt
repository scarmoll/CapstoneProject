package com.example.capstone.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.Data.IndividualPart
import com.example.capstone.Data.IndividualPartAdapter
import com.example.capstone.R
import com.example.capstone.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.fragment_individual_parts.*
import kotlinx.android.synthetic.main.item_individual_part.*

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
                for (i in IndividualPart.STRAP_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.STRAP_NAME[i],
                            IndividualPart.STRAP_PRICE[i]
                        )
                    )
                }
            }

            1 -> {
                for (i in IndividualPart.BEZEL_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.BEZEL_NAME[i],
                            IndividualPart.BEZEL_PRICE[i]
                        )
                    )
                }
            }

            2 -> {
                for (i in IndividualPart.INSERT_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.INSERT_NAME[i],
                            IndividualPart.INSERT_PRICE[i]
                        )
                    )
                }
            }

            3 -> {
                for (i in IndividualPart.CHAPTER_RING_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.CHAPTER_RING_NAME[i],
                            IndividualPart.CHAPTER_RING_PRICE[i]
                        )
                    )
                }
            }

            4 -> {
                for (i in IndividualPart.GLASS_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.GLASS_NAME[i],
                            IndividualPart.GLASS_PRICE[i]
                        )
                    )
                }
            }

            5 -> {
                for (i in IndividualPart.CROWN_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.CROWN_NAME[i],
                            IndividualPart.CROWN_PRICE[i]
                        )
                    )
                }
            }

            6 -> {
                for (i in IndividualPart.CASE_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.CASE_NAME[i],
                            IndividualPart.CASE_PRICE[i]
                        )
                    )
                }
            }

            7 -> {
                for (i in IndividualPart.DIAL_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.DIAL_NAME[i],
                            IndividualPart.DIAL_PRICE[i]
                        )
                    )
                }
            }

            8 -> {
                for (i in IndividualPart.HANDS_NAME.indices) {
                    individualPartList.add(
                        IndividualPart(
                            IndividualPart.HANDS_NAME[i],
                            IndividualPart.HANDS_PRICE[i]
                        )
                    )
                }
            }
        }

//        for (i in IndividualPart.NAME.indices) {
//            individualPartList.add(
//                IndividualPart(
//                    IndividualPart.NAME[i],
//                    IndividualPart.PRICE[i]
//                )
//            )
//        }

        individualPartListAdapter.notifyDataSetChanged()
    }
}