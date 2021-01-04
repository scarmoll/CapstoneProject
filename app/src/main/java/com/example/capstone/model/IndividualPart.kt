package com.example.capstone.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.capstone.R

@Entity(tableName = "CartTable")
data class IndividualPart(

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "price")
    var price: Double,

    @ColumnInfo(name = "image_res_id")
    @DrawableRes
    var imageResId: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) {
    companion object {
        val STRAP_NAME = arrayOf(
            "Zwart Rubberen band",
            "Blauw Rubberen band",
            "Zwarte NATO band",
            "Metalen Super-J band",
            "Zwarte Metalen band"
        )

        val STRAP_PRICE = arrayOf(
            24.99,
            24.99,
            29.99,
            49.99,
            49.99
        )

        val STRAP_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.strap_rubber_black,
            R.drawable.strap_rubber_blue,
            R.drawable.strap_nato_black,
            R.drawable.strap_metal_super_j,
            R.drawable.strap_metal_black,
        )

        val BEZEL_NAME = arrayOf(
            "Stalen LX bezel zilver",
            "Stalen LX bezel zwart",
            "Stalen LX bezel brons",
            "Stalen Deep Sea zilver",
            "Stalen Deep Sea zwart",
            "Stalen Coin Edge zilver",
        )

        val BEZEL_PRICE = arrayOf(
            30.50,
            30.50,
            30.50,
            25.50,
            25.50,
            25.50,
        )

        val BEZEL_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.bezel_brushed_steel,
            R.drawable.bezel_brushed_black,
            R.drawable.bezel_brushed_bronze,
            R.drawable.bezel_deep_sea_silver,
            R.drawable.bezel_deep_sea_black,
            R.drawable.bezel_coin_edge_silver
        )

        val INSERT_NAME = arrayOf(
            "Yacht Master staal gun metal",
            "Yacht Master staal blue",
            "Dual Time staal zilver",
            "Dual Time staal gun metal",
            "Yacht Master keramisch zwart",
            "Yacht Master keramisch goud",
            "007 SMP zwart"
        )

        val INSERT_PRICE = arrayOf(
            37.50,
            37.50,
            29.50,
            29.50,
            37.50,
            37.50,
            30.50
        )

        val INSERT_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.insert_ym_steel_gun_metal,
            R.drawable.insert_ym_steel_blue,
            R.drawable.insert_dual_time_steel_silver,
            R.drawable.insert_dual_time_steel_gun_metal,
            R.drawable.insert_ym_ceramic_black,
            R.drawable.insert_ym_ceramic_gold,
            R.drawable.insert_007_smp_black
        )

        val CHAPTER_RING_NAME = arrayOf(
            "Stalen chapter ring zwart",
            "Stalen chapter ring zilver",
            "Basic chapter ring zwart met wit",
            "Basic chapter ring zwart",
            "60Min chapter ring zwart",
            "60Min chapter ring wit",
        )

        val CHAPTER_RING_PRICE = arrayOf(
            16.50,
            16.50,
            16.50,
            16.50,
            16.50,
            16.50
        )

        val CHAPTER_RING_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.chapter_ring_polished_black,
            R.drawable.chapter_ring_polished_steel_silver,
            R.drawable.chapter_ring_markers_black,
            R.drawable.chapter_ring_markers_black_on_black,
            R.drawable.chapter_ring_60_black,
            R.drawable.chapter_ring_60_white
        )

        val GLASS_NAME = arrayOf(
            "Saffier glas Type-E",
            "Saffier glas plat",
            "Saffier glas double dome",
            "Saffier glas double dome NB",
            "Saffier glas top hat"
        )

        val GLASS_PRICE = arrayOf(
            28.50,
            37.50,
            37.50,
            37.50,
            37.50
        )

        val GLASS_RING_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.glass_sapphire_type_e,
            R.drawable.glass_sapphire_flat,
            R.drawable.glass_sapphire_dd,
            R.drawable.glass_sapphire_dd_nb,
            R.drawable.glass_sapphire_top_hat
        )

        val CROWN_NAME = arrayOf(
            "Stalen kroon zwart",
            "Stalen kroon zilver",
            "Stalen kroon brons",
            "Stalen kroon mat zwart",
            "PVD kroon zwart",
            "PVD kroon goud",
        )

        val CROWN_PRICE = arrayOf(
            23.50,
            23.50,
            23.50,
            23.50,
            23.50,
            23.50,
        )

        val CROWN_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.crown_polished_steel_black,
            R.drawable.crown_steel_silver,
            R.drawable.crown_steel_bronze,
            R.drawable.crown_steel_matt_black,
            R.drawable.crown_pvd_black,
            R.drawable.crown_pvd_gold,
        )


        val CASE_NAME = arrayOf(
            "Stalen kast zilver",
            "Stalen kast brons",
            "Stalen kast zwart",
            "Stalen kast goud",
            "Stalen kast rose gold",
        )

        val CASE_PRICE = arrayOf(
            69.99,
            74.50,
            74.50,
            74.50,
            68.50,
        )

        val CASE_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.case_polished_steel,
            R.drawable.case_steel_bronze,
            R.drawable.case_steel_black,
            R.drawable.case_steel_gold,
            R.drawable.case_steel_rose_gold,
        )

        val DIAL_NAME = arrayOf(
            "Voyager 2 zwart",
            "Voyager 2 wit",
            "Voyager 2 groen",
            "Voyager 2 blauw",
            "Golf blauw",
            "Kersen bloesem zilver",
        )

        val DIAL_PRICE = arrayOf(
            30.50,
            30.50,
            30.50,
            30.50,
            17.50,
            73.50
        )

        val DIAL_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.dial_voyager_2_black,
            R.drawable.dial_voyager_2_white,
            R.drawable.dial_voyager_2_green,
            R.drawable.dial_voyager_2_blue,
            R.drawable.dial_wave_blue,
            R.drawable.dial_cherry_blossom_silver,
        )

        val HANDS_NAME = arrayOf(
            "Marine Master wijzers",
            "Mercedes wijzers",
            "Ranger wijzers",
            "Mil-spec wijzers",
            "Grand Seiko wijzers",
            "Field Spec wijzers",
        )

        val HANDS_PRICE = arrayOf(
            19.50,
            19.50,
            19.50,
            19.50,
            19.50,
            19.50,
        )

        val HANDS_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.hands_mm_silver,
            R.drawable.hands_merc,
            R.drawable.hands_ranger,
            R.drawable.hands_mil_spec,
            R.drawable.hands_grand_seiko,
            R.drawable.hands_field_spec
        )
    }
}