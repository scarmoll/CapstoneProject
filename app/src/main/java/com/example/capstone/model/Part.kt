package com.example.capstone.model

import androidx.annotation.DrawableRes
import com.example.capstone.R

data class Part(
    var name: String,
    var description: String,
    @DrawableRes var imageResId: Int
) {
    companion object {
        val PART_NAME = arrayOf(
            "Bandje",
            "Bezels",
            "Bezel Inserts",
            "Chapter Ring",
            "Glas",
            "Kroon",
            "Kast",
            "Wijzerplaat",
            "Wijzers"
        )

        val PART_DESCRIPTION = arrayOf(
            "Hier kan u kiezen uit verschillende bandjes",
            "Hier kan u kiezen uit verschillende bezels",
            "Hier kan u kiezen uit verschillende bezel insert",
            "Hier kan u kiezen uit verschillende chapter rings",
            "Hier kan u kiezen uit verschillende soorten glas",
            "Hier kan u kiezen uit verschillende kronen",
            "Hier kan u kiezen uit verschillende kasten",
            "Hier kan u kiezen uit verschillende wijzerplaten",
            "Hier kan u kiezen uit verschillende wijzers"
        )

        val PART_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.strap_rubber_black,
            R.drawable.bezel_brushed_steel,
            R.drawable.insert_ym_steel_gun_metal,
            R.drawable.chapter_ring_polished_black,
            R.drawable.glass_sapphire_type_e,
            R.drawable.crown_polished_steel_black,
            R.drawable.case_polished_steel,
            R.drawable.dial_voyager_2_black,
            R.drawable.hands_mm_silver
        )
    }
}