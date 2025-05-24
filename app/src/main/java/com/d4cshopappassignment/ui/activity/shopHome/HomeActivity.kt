package com.d4cshopappassignment.ui.activity.shopHome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.checkmycharger.shopappassignment.R
import com.d4cshopappassignment.data.Product
import com.d4cshopappassignment.data.PromoCard
import com.d4cshopappassignment.data.promoCards
import com.d4cshopappassignment.data.sampleCategories
import com.d4cshopappassignment.data.sampleProducts
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                color = Color(0xFF2C2C2C)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Fixed Top Bar
                    ShopTopBar()

                    // Scrollable Content
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 16.dp),
                        contentPadding = PaddingValues(bottom = 100.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        item {
                            CategoriesSection(categories = sampleCategories)
                        }

                        item {
                            PromoCardBanner(promoCards)
                        }

                        item {
                            NewProductsHeader()
                        }

                        items (sampleProducts) { prod ->
                            ProductCard(prod)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Top Bar
 */

@Composable
fun ShopTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Shop",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.century_old_style_std_bold))
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "Wishlist",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "Cart",
                tint = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

/**
 * Categories Section
 */
@Composable
fun CategoriesSection(
    categories: List<com.d4cshopappassignment.data.Category>,
    onSeeAllClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.century_old_style_std_bold))
            )
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodyMedium.copy(
                    textDecoration = TextDecoration.Underline,
                    color = Color.White
                ),
                modifier = Modifier.clickable { onSeeAllClicked() }
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items (categories){
                CategoryItem(it)
            }
        }
    }
}

@Composable
fun CategoryItem(category: com.d4cshopappassignment.data.Category) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.categorysample),
            contentDescription = category.name,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            maxLines = 1
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PromoCardBanner(
    cards: List<PromoCard>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()

    Box(modifier = modifier) {
        HorizontalPager(
            count = cards.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.6f)
        ) { page ->
            PromoCardItem(card = cards[page])
        }

        // Dot Indicators
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 72.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(cards.size) { index ->
                Box(
                    modifier = Modifier
                        .size(width = 24.dp, height = 6.dp)
                        .background(
                            if (pagerState.currentPage == index) Color.Green else Color.Black,
                            shape = RoundedCornerShape(3.dp)
                        )
                )
            }
        }
    }
}

@Composable
fun PromoCardItem(card: PromoCard) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.shopflowcard1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
        ) {
            Text(
                text = card.title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
            Text(
                text = card.subtitle,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp)
            )
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                ),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = card.buttonText)
            }
        }
    }
}

@Composable
fun NewProductsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("New Products", style = MaterialTheme.typography.titleMedium, color = Color.White)
        Text("See All", color = Color(0xFFBB86FC), modifier = Modifier.clickable { })
    }
}



@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(horizontal = 16.dp)
    ) {
        // Background PNG
        Image(
            painter = painterResource(id = R.drawable.product_title_card),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Top-left Favorite Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = "Favorite",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )

        // Product Image
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.title,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.6f)
                .aspectRatio(1f)
        )

        // Optional Best Seller badge
        if (product.isBestSeller) {
            Text(
                text = "Best Seller",
                color = Color.Black,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .background(Color.Green, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .padding(end = 16.dp)
            )
        }

        // Bottom Overlay with Product Details
        ProductDetailsOverlay(product)

        // Bottom-right decorative icon (inside PNG cutout)
        Icon(
            painter = painterResource(id = R.drawable.item_cart),
            contentDescription = "Bottom icon",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}


@Composable
fun ProductDetailsOverlay(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xCC000000))
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(product.title, color = Color(0xFF4CAF50), style = MaterialTheme.typography.titleMedium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                val stockColor = if (product.inStock) Color(0xFF4CAF50) else Color.Red
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(stockColor, shape = CircleShape)
                )
                Text(
                    text = if (product.inStock) " In Stock" else " Out of Stock",
                    color = stockColor,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Text(product.description, color = Color.White, style = MaterialTheme.typography.bodySmall)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(product.price, color = Color.White, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = " ${product.originalPrice}",
                style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.LineThrough),
                color = Color.Gray
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            repeat(5) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rate_star),
                    contentDescription = "Star",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp)
                )
            }
            Text("${product.reviewsCount} reviews", color = Color.White, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(start = 8.dp))
        }
    }
}






