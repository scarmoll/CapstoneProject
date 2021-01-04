package com.example.capstone.model

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
            "Hier kan kiezen uit verschillende bandjes",
            "Hier kan kiezen uit verschillende bezels",
            "Hier kan kiezen uit verschillende bezel insert",
            "Hier kan kiezen uit verschillende chapter rings",
            "Hier kan kiezen uit verschillende soorten glas",
            "Hier kan kiezen uit verschillende kronen",
            "Hier kan kiezen uit verschillende kasten",
            "Hier kan kiezen uit verschillende wijzerplaten",
            "Hier kan kiezen uit verschillende wijzers"
        )
    }
}