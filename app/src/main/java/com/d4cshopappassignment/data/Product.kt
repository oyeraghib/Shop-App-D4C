package com.d4cshopappassignment.data

import com.checkmycharger.shopappassignment.R

data class Product(
    val title: String,
    val description: String,
    val secondDescription: String = "Checking",
    val price: String,
    val originalPrice: String,
    val imageRes: Int,
    val isBestSeller: Boolean,
    val inStock: Boolean,
    val reviewsCount: Int
)

val sampleProducts = listOf(
    Product(
        title = "Clencera",
        description = "Gentle face cleanser for daily use.",
        price = "$19.99",
        originalPrice = "$24.99",
        imageRes = R.drawable.product_image,
        isBestSeller = true,
        inStock = true,
        reviewsCount = 249
    ),
    Product(
        title = "Glow",
        description = "Vitamin C serum for brighter skin.",
        price = "$29.99",
        originalPrice = "$39.99",
        imageRes = R.drawable.product_image,
        isBestSeller = false,
        inStock = true,
        reviewsCount = 120
    ),
    Product(
        title = "AfterGlow",
        description = "Nourishing night cream for hydration.",
        price = "$34.99",
        originalPrice = "$44.99",
        imageRes = R.drawable.product_image,
        isBestSeller = true,
        inStock = false,
        reviewsCount = 15
    )
)

