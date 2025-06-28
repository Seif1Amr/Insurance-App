package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFEEEEEE))) {
        Text(
            text = "Insure Products",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA)) // Marble white background
                .padding(top = 56.dp, bottom = 24.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface // Ensure good contrast
        )
        SimpleLazyColumn(modifier = Modifier.weight(1f).fillMaxWidth())
    }
}

@Composable
fun SimpleLazyColumn(modifier: Modifier = Modifier) {
    // Updated list of items
    val itemsList = listOf(
        "Make a Claim",
        "Privacy Policy",
        "Terms of Use",
        "About Us",
        "Contact Us",
        "Pricing"
    )

    LazyColumn(modifier = modifier) { // Removed fillMaxWidth here as it's on the Column in AppScreen
        items(itemsList) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp) // Padding around the border
                    .border(BorderStroke(1.dp, Color(0xFFADD8E6)))
                    .padding(horizontal = 8.dp, vertical = 24.dp) // Increased vertical padding inside the border
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        AppScreen()
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
    TestTheme {
        Greeting("Android")
    }
}
