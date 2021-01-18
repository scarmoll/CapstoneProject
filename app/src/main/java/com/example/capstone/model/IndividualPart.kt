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
    @DrawableRes var imageResId: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) {
    companion object {
        val STRAPS = arrayOf(
            IndividualPart(
                "Zwarte bandje",
                24.99,
                R.drawable.strap_rubber_black
            ),
            IndividualPart(
                "Blauw Rubberen band",
                24.99,
                R.drawable.strap_rubber_blue
            ),
            IndividualPart(
                "Zwarte NATO band",
                29.99,
                R.drawable.strap_nato_black
            ),
            IndividualPart(
                "Metalen SUPER-J band",
                49.99,
                R.drawable.strap_metal_super_j
            ),
            IndividualPart(
                "Zwart Metalen band",
                49.99,
                R.drawable.strap_metal_black
            ),
        )

        val BEZELS = arrayOf(
            IndividualPart(
                "Stalen LX bezel zilver",
                30.50,
                R.drawable.bezel_brushed_steel
            ),
            IndividualPart(
                "Stalen LX bezel zwart",
                30.50,
                R.drawable.bezel_brushed_black,
            ),
            IndividualPart(
                "Stalen LX bezel brons",
                30.50,
                R.drawable.bezel_brushed_bronze,
            ),
            IndividualPart(
                "Stalen Deep Sea zilver",
                25.50,
                R.drawable.bezel_deep_sea_silver,
            ),
            IndividualPart(
                "Stalen Deep Sea zwart",
                25.50,
                R.drawable.bezel_deep_sea_black,
            ),
            IndividualPart(
                "Stalen Coin Edge zilver",
                25.50,
                R.drawable.bezel_coin_edge_silver
            ),
        )

        val INSERTS = arrayOf(
            IndividualPart(
                "Yacht Master staal gun metal",
                37.50,
                R.drawable.insert_ym_steel_gun_metal,
            ),
            IndividualPart(
                "Yacht Master staal blue",
                37.50,
                R.drawable.insert_ym_steel_blue,
            ),
            IndividualPart(
                "Dual Time staal zilver",
                29.50,
                R.drawable.insert_dual_time_steel_silver,
            ),
            IndividualPart(
                "Dual Time staal gun metal",
                29.50,
                R.drawable.insert_dual_time_steel_gun_metal,
            ),
            IndividualPart(
                "Yacht Master keramisch zwart",
                37.50,
                R.drawable.insert_ym_ceramic_black,
            ),
            IndividualPart(
                "Yacht Master keramisch goud",
                37.50,
                R.drawable.insert_ym_ceramic_gold,
            ),
            IndividualPart(
                "007 SMP zwart",
                30.50,
                R.drawable.insert_007_smp_black
            ),
        )

        val CHAPTER_RINGS = arrayOf(
            IndividualPart(
                "Stalen chapter ring zwart",
                16.50,
                R.drawable.chapter_ring_polished_black,
            ),
            IndividualPart(
                "Stalen chapter ring zilver",
                16.50,
                R.drawable.chapter_ring_polished_steel_silver,
            ),
            IndividualPart(
                "Basic chapter ring zwart met wit",
                16.50,
                R.drawable.chapter_ring_markers_black,
            ),
            IndividualPart(
                "Basic chapter ring zwart",
                16.50,
                R.drawable.chapter_ring_markers_black_on_black,
            ),
            IndividualPart(
                "60Min chapter ring zwart",
                16.50,
                R.drawable.chapter_ring_60_black,
            ),
            IndividualPart(
                "60Min chapter ring wit",
                16.50,
                R.drawable.chapter_ring_60_white
            ),
        )

        val GLASS = arrayOf(
            IndividualPart(
                "Saffier glas Type-E",
                28.50,
                R.drawable.glass_sapphire_type_e,
            ),
            IndividualPart(
                "Saffier glas plat",
                37.50,
                R.drawable.glass_sapphire_flat,
            ),
            IndividualPart(
                "Saffier glas double dome",
                37.50,
                R.drawable.glass_sapphire_dd,
            ),
            IndividualPart(
                "Saffier glas double dome NB",
                37.50,
                R.drawable.glass_sapphire_dd_nb,
            ),
            IndividualPart(
                "Saffier glas top hat",
                37.50,
                R.drawable.glass_sapphire_top_hat
            ),
        )

        val CROWNS = arrayOf(
            IndividualPart(
                "Stalen kroon zwart",
                23.50,
                R.drawable.crown_polished_steel_black,
            ),
            IndividualPart(
                "Stalen kroon zilver",
                23.50,
                R.drawable.crown_steel_silver,
            ),
            IndividualPart(
                "Stalen kroon brons",
                23.50,
                R.drawable.crown_steel_bronze,
            ),
            IndividualPart(
                "Stalen kroon mat zwart",
                23.50,
                R.drawable.crown_steel_matt_black,
            ),
            IndividualPart(
                "PVD kroon zwart",
                23.50,
                R.drawable.crown_pvd_black,
            ),
            IndividualPart(
                "PVD kroon goud",
                23.50,
                R.drawable.crown_pvd_gold,
            ),
        )

        val CASES = arrayOf(
            IndividualPart(
                "Stalen kast zilver",
                69.99,
                R.drawable.case_polished_steel,
            ),
            IndividualPart(
                "Stalen kast brons",
                74.50,
                R.drawable.case_steel_bronze,
            ),
            IndividualPart(
                "Stalen kast zwart",
                74.50,
                R.drawable.case_steel_black,
            ),
            IndividualPart(
                "Stalen kast goud",
                74.50,
                R.drawable.case_steel_gold,
            ),
            IndividualPart(
                "Stalen kast rose gold",
                68.50,
                R.drawable.case_steel_rose_gold,
            ),
        )

        val DIALS = arrayOf(
            IndividualPart(
                "Voyager 2 zwart",
                30.50,
                R.drawable.dial_voyager_2_black,
            ),
            IndividualPart(
                "Voyager 2 wit",
                30.50,
                R.drawable.dial_voyager_2_white,
            ),
            IndividualPart(
                "Voyager 2 groen",
                30.50,
                R.drawable.dial_voyager_2_green,
            ),
            IndividualPart(
                "Voyager 2 blauw",
                30.50,
                R.drawable.dial_voyager_2_blue,
            ),
            IndividualPart(
                "Golf blauw",
                17.50,
                R.drawable.dial_wave_blue,
            ),
            IndividualPart(
                "Kersen bloesem zilver",
                73.50,
                R.drawable.dial_cherry_blossom_silver,
            ),
        )

        val HANDS = arrayOf(
            IndividualPart(
                "Marine Master wijzers",
                19.50,
                R.drawable.hands_mm_silver,
            ),
            IndividualPart(
                "Mercedes wijzers",
                19.50,
                R.drawable.hands_merc,
            ),
            IndividualPart(
                "Ranger wijzers",
                19.50,
                R.drawable.hands_ranger,
            ),
            IndividualPart(
                "Mil-spec wijzers",
                19.50,
                R.drawable.hands_mil_spec,
            ),
            IndividualPart(
                "Grand Seiko wijzers",
                19.50,
                R.drawable.hands_grand_seiko,
            ),
            IndividualPart(
                "Field Spec wijzers",
                19.50,
                R.drawable.hands_field_spec
            ),
        )
    }
}