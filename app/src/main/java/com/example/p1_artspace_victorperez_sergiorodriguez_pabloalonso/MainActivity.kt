package com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso.ui.theme.P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme

class MainActivity : ComponentActivity() {
    val imageList = ImageList(listOf(
        Art("Doge", "The doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126)
    ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
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
    P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme {
        Greeting("Android")
    }
}