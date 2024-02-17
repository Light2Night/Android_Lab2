package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}

data class ArtData(val image: Painter, val topic: String, val author: String, val year: Int)

@Composable
fun Body() {
    val currentArtIndex = remember {
        mutableStateOf(0)
    }
    val arts = arrayOf(
        ArtData(painterResource(R.drawable.img1), "Cat", "IDK", 2000),
        ArtData(painterResource(R.drawable.img2), "Woman", "IDK 2", 1990),
        ArtData(painterResource(R.drawable.img3), "Polygon cat", "IDK 3", 1980)
    )

    val currentArt = remember {
        mutableStateOf(arts[currentArtIndex.value])
    }

    Column(
        modifier = Modifier
            .padding(10.dp, 0.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(10.dp)
                ) {
                    Image(
                        modifier = Modifier,
                        painter = currentArt.value.image,
                        contentDescription = "Art",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit
                    )
                }

                Column(

                ) {
                    Text(text = currentArt.value.topic)
                    Row {
                        Text(text = currentArt.value.author)
                        Text(text = " ")
                        Text(text = "(${currentArt.value.year})")
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    currentArtIndex.value = (currentArtIndex.value - 1);

                    if (currentArtIndex.value < 0)
                        currentArtIndex.value = arts.size - 1;

                    currentArt.value = arts[currentArtIndex.value];
                }
            ) {
                Text(
                    modifier = Modifier
                        .width(80.dp)
                        .wrapContentSize(Alignment.Center),
                    text = "Previous",
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = {
                    currentArtIndex.value = (currentArtIndex.value + 1) % arts.size;
                    currentArt.value = arts[currentArtIndex.value];
                }
            ) {
                Text(
                    modifier = Modifier
                        .width(80.dp)
                        .wrapContentSize(Alignment.Center),
                    text = "Next",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BodyPreview() {
    Lab2Theme {
        Body()
    }
}