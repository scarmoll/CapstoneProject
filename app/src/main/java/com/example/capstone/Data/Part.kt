package com.example.capstone.Data

data class Part(
    var name: String,
    var description: String
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
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4",
            "Description 5",
            "Description 6",
            "Description 7",
            "Description 8",
            "Description 9"
        )
    }
}