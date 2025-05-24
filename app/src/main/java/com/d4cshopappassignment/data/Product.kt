package com.d4cshopappassignment.data

import com.checkmycharger.shopappassignment.R

data class Product(
    val title: String,
    val description: String,
    val secondDescription: String = "Dry & Dehydrated skin",
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
        price = "RS. 19.99",
        originalPrice = "RS. 24.99",
        imageRes = R.drawable.product_image,
        isBestSeller = true,
        inStock = true,
        reviewsCount = 144
    ),
    Product(
        title = "Glow",
        description = "Vitamin C serum for brighter skin.",
        price = "RS. 29.99",
        originalPrice = "RS. 39.99",
        imageRes = R.drawable.product_image,
        isBestSeller = false,
        inStock = true,
        reviewsCount = 120
    ),
    Product(
        title = "AfterGlow",
        description = "Nourishing night cream for hydration.",
        price = "RS. 34.99",
        originalPrice = "RS. 44.99",
        imageRes = R.drawable.product_image,
        isBestSeller = true,
        inStock = false,
        reviewsCount = 15
    )
)

