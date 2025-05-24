package com.d4cshopappassignment.ui.activity.shopHome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.checkmycharger.shopappassignment.R
import com.d4cshopappassignment.data.sampleCategories

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .statusBarsPadding(),
                color = Color.Black
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top
                ) {
                    ShopTopBar()
                    CategoriesSection(categories = sampleCategories)
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
            color = Color.White
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
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFBB86FC),
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

