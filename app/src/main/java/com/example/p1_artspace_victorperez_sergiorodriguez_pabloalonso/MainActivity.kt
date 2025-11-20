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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1_artspace_victorperez_sergiorodriguez_pabloalonso.ui.theme.P1_ArtSpace_VictorPerez_SergioRodriguez_PabloAlonsoTheme

class MainActivity : ComponentActivity() {
    val imageList = ImageList(
        listOf(
            Art("Doge", "The doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126),
            Art("Tau5", "Pablo", 2023, R.drawable.tau),
            Art("Chuwi12", "Sergio", 2024, R.drawable.sehiogithub),
            Art("DjVicthor-sh", "Victhor", 2018, R.drawable.usr001)
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

@Preview
@Composable
fun previewApp(modifier: Modifier = Modifier) {
    val imageList = ImageList(
        listOf(
            Art("Doge", "The doge creator", 2010, R.drawable.doge_meme_png_photos_1504254126),
            Art("Tau5", "Pablo", 2023, R.drawable.tau),
            Art("Chuwi12", "Sergio", 2024, R.drawable.sehiogithub),
            Art("DjVicthor-sh", "Victhor", 2018, R.drawable.usr001)
        )
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        MainComponent(imageList = imageList, modifier = Modifier.safeDrawingPadding())
    }
}

@Composable
fun ArtDisplay(art: Art, artNumber: Int, maxArt: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            bottom = 24.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            art.title,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 48.dp, top = 24.dp)
        )
        Column(modifier = Modifier.weight(1f).padding(bottom = 48.dp), verticalArrangement = Arrangement.Center) {
            Surface(shadowElevation = 8.dp, tonalElevation = 8.dp) {
                Image(
                    painter = painterResource(art.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Text(
            "${art.artist} (${art.year})",
            fontSize = 24.sp
        )
        Text(
            "Imagen ${artNumber}/${maxArt}",
            fontSize = 24.sp
        )
    }
}


@Composable
fun NextPreviousButtons(value: Int, onValueChange: (Int) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(

        )
    ) {
        Column(modifier = modifier.padding(end = 4.dp)) {
            Button(onClick = {
                onValueChange(value - 1)

            }) {
                Text(
                    "Previous",
                    fontSize = 24.sp
                )
            }
        }
        Column() {
            Button(onClick = {
                onValueChange(value + 1)
            }) {
                Text(
                    "Next",
                    fontSize = 24.sp
                )
            }
        }
    }

}


@Composable
fun MainComponent(imageList: ImageList, modifier: Modifier = Modifier) {
    var selectedArtIndex by remember { mutableStateOf(0) };

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(24.dp)
    ) {
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
                if (it == -1) {
                    selectedArtIndex = imageList.count() - 1
                } else if (it == imageList.count()) {
                    selectedArtIndex = 0
                } else if (it >= 0 && it < imageList.count()) {
                    selectedArtIndex = it;
                }
            }
        )
    }
}





