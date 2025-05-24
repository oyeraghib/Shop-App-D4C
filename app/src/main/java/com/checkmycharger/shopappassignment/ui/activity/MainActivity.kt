package com.checkmycharger.shopappassignment.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.checkmycharger.shopappassignment.ui.activity.shopHome.HomeActivity
import com.checkmycharger.shopappassignment.ui.theme.ShopAppAssignmentTheme
import java.util.logging.Logger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Logger.getLogger("main").info("MainActivity started")
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

        finish()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopAppAssignmentTheme {
        Greeting("Android")
    }
}