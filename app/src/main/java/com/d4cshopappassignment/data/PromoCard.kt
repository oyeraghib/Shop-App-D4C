package com.d4cshopappassignment.data

import androidx.compose.ui.graphics.Color

data class PromoCard(
    val title: String,
    val subtitle: String,
    val buttonText: String,
    val buttonBgColor: Color = Color.White
)

val promoCards = listOf(
    PromoCard("Big Discount", "Up to 50% off", "Shop Now"),
    PromoCard("New Arrival", "Fresh skincare", "Explore"),
    PromoCard("Bestsellers", "Top-rated items", "View All")
)
