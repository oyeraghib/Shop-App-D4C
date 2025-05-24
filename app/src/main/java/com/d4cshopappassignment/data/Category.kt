package com.d4cshopappassignment.data

data class Category(val id: Int, val name: String)

val sampleCategories = listOf(
    Category(1, "Cleansers"),
    Category(2, "Toner"),
    Category(3, "Serums"),
    Category(4, "Face Oil"),
    Category(5, "Moisturiser"),
    Category(6, "Sunscreens")
)
