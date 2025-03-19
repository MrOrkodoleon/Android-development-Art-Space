package com.example.artspace

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class Artwork(val imageRes: Int, val title: String, val artist: String)

@Composable
fun ArtSpaceLayout() {
    val artworks = listOf(
        Artwork(R.drawable.img1, "Starry Night", "Vincent van Gogh (1889)"),
        Artwork(R.drawable.img2, "Mona Lisa", "Leonardo da Vinci (1503)"),
        Artwork(R.drawable.img3, "The Scream", "Edvard Munch (1893)")
    )

    var currentIndex by remember { mutableIntStateOf(0) }
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = artworks[currentIndex].title,
                            fontSize = 18.sp
                        )
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = artworks[currentIndex].artist
                        )
                    }
                }
            }
            Image(
                painter = painterResource(artworks[currentIndex].imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(500.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.9f)
            ) {
                Button(
                    onClick = { currentIndex = (currentIndex - 1 + artworks.size) % artworks.size },
                    modifier = Modifier.padding(14.dp, 2.dp)
                ) {
                    Text(text = "Previous", fontSize = 12.sp)
                }
                Button(
                    onClick = { currentIndex = (currentIndex + 1) % artworks.size },
                    modifier = Modifier.padding(14.dp, 2.dp)
                ) {
                    Text(text = "Next", fontSize = 12.sp)
                }
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(artworks[currentIndex].imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(500.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = artworks[currentIndex].title,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = artworks[currentIndex].artist
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { currentIndex = (currentIndex - 1) % artworks.size },
                    modifier = Modifier.padding(14.dp, 2.dp)
                ) {
                    Text(text = "Previous", fontSize = 12.sp)
                }
                Button(
                    onClick = { currentIndex = (currentIndex + 1) % artworks.size },
                    modifier = Modifier.padding(14.dp, 2.dp)
                ) {
                    Text(text = "Next", fontSize = 12.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceLayout()
}
