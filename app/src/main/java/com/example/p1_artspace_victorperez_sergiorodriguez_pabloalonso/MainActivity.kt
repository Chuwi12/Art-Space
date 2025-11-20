package com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso.ui.theme.P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme

class MainActivity : ComponentActivity() {
    val imageList = ImageList(
        listOf(
            Art("Doge", "The doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126),
            Art("Doge2", "The *second* doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComponent(imageList = imageList, modifier = Modifier.safeDrawingPadding())
                }
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
        Text(art.title)
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(art.image),
                contentDescription = null,
                modifier = modifier.fillMaxSize()
            )
        }
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
fun NextPreviousButtons(value: Int, onValueChange: (Int) -> Unit, modifier: Modifier = Modifier) {
    Row() {
        Column(modifier = modifier.padding(end = 4.dp)) {
            Button(onClick = {
                onValueChange(value - 1)
            }) {
                Text("Previous")
            }
        }
        Column() {
            Button(onClick = {
                onValueChange(value + 1)
            }) {
                Text("Next")
            }
        }
    }

}

@Composable
fun MainComponent(imageList: ImageList, modifier: Modifier = Modifier) {
    var selectedArtIndex by remember { mutableStateOf(0) };

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        imageList.getImage(selectedArtIndex)?.let {
            ArtDisplay(
                it,
                selectedArtIndex + 1,
               imageList.count(),
                modifier = Modifier.weight(1f)
            )
        } ?: run {
            Text("Error: Art not found")
        }
        NextPreviousButtons(
            value = selectedArtIndex,
            onValueChange = {
                if (it >= 0 && it < imageList.count()) {
                    selectedArtIndex = it;
                }
            }
        )
    }
}
