package com.example.artspace

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
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

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier){
    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Image(
           painter = painterResource(R.drawable.img),
           contentDescription = null,
           contentScale = ContentScale.Fit,
           modifier = Modifier.size(500.dp)
       )

        Spacer(modifier = Modifier.height(16.dp))
        Surface (
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Artwork Title",
                    fontSize = 18.sp
                )
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Artwork Artist (Year)"
                )
            }

        }

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Button(onClick = {},
                modifier = Modifier.padding(14.dp,2.dp)
            ) {
                Text(
                    text = "Previous",
                    fontSize = 12.sp
                )
            }
            Spacer(
                modifier = Modifier.weight(0.5F,true)
            )
            Button(onClick = { },
                modifier = Modifier.padding(14.dp,2.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceLayout(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}