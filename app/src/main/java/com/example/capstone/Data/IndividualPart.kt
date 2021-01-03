package com.example.capstone.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CartTable")
data class IndividualPart(

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "price")
    var price: Double,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) {
    companion object {
        val STRAP_NAME = arrayOf(
            "Zwart Rubberen band",
            "Blauw rubberen band",
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

        val BEZEL_NAME = arrayOf(
            "Bezel 1",
            "Bezel 2",
            "Bezel 3",
            "Bezel 4",
            "Bezel 5",
            "Bezel 6",
        )

        val BEZEL_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val INSERT_NAME = arrayOf(
            "Insert 1",
            "Insert 2",
            "Insert 3",
            "Insert 4",
            "Insert 5",
            "Insert 6",
        )

        val INSERT_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val CHAPTER_RING_NAME = arrayOf(
            "Chapter Ring 1",
            "Chapter Ring 2",
            "Chapter Ring 3",
            "Chapter Ring 4",
            "Chapter Ring 5",
            "Chapter Ring 6",
        )

        val CHAPTER_RING_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val GLASS_NAME = arrayOf(
            "Glas 1",
            "Glas 2",
            "Glas 3",
            "Glas 4",
            "Glas 5",
            "Glas 6",
        )

        val GLASS_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val CROWN_NAME = arrayOf(
            "Kroon 1",
            "Kroon 2",
            "Kroon 3",
            "Kroon 4",
            "Kroon 5",
            "Kroon 6",
        )

        val CROWN_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )


        val CASE_NAME = arrayOf(
            "Kast 1",
            "Kast 2",
            "Kast 3",
            "Kast 4",
            "Kast 5",
            "Kast 6",
        )

        val CASE_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val DIAL_NAME = arrayOf(
            "Wijzerplaat 1",
            "Wijzerplaat 2",
            "Wijzerplaat 3",
            "Wijzerplaat 4",
            "Wijzerplaat 5",
            "Wijzerplaat 6",
        )

        val DIAL_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )

        val HANDS_NAME = arrayOf(
            "Wijzer 1",
            "Wijzer 2",
            "Wijzer 3",
            "Wijzer 4",
            "Wijzer 5",
            "Wijzer 6",
        )

        val HANDS_PRICE = arrayOf(
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
            40.99,
        )
    }
}