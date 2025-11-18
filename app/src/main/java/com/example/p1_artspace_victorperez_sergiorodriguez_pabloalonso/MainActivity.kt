package com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso.ui.theme.P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme

class MainActivity : ComponentActivity() {
    val imageList = ImageList(
        listOf(
            Art("Doge", "The doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme {

                GreetingPreview()

            }
        }
    }
}


@Composable
fun ArtDisplay(art: Art, artNumber: Int, maxArt: Int, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row() {
            Text(art.title)
        }

        Image(
            painter = painterResource(art.image),
            contentDescription = null,
            modifier = modifier.size(200.dp)
        )

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${art.artist}(${art.year})")
            Text("Imagen ${artNumber}/${maxArt}")
        }


    }
}


@Composable
fun NextPreviousButtons(onValueChange: (Int) -> Unit, modifier: Modifier = Modifier) {

    Row() {
        Column(modifier = modifier.padding(end = 4.dp)) {
            Button(onClick = {}) {
                Text("Previous")
            }
        }
        Column() {
            Button(onClick = {}) {
                Text("Next")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtDisplay(
                Art(
                    "Doge",
                    "Torbe",
                    2010,
                    R.drawable.doge_meme_png_photos_1504254126
                ),
                1,
                5
            )


        }
    }
}
