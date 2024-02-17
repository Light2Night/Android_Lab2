package com.example.lab2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@Composable
fun Body() {
    val currentImageIndex = remember {
        mutableStateOf(0)
    }
    val images = arrayOf(
        painterResource(R.drawable.img1),
        painterResource(R.drawable.img2)
    )

    val currentImage = remember {
        mutableStateOf(images[currentImageIndex.value])
    }

    Column(
        modifier = Modifier
            .padding(10.dp, 0.dp)
    ) {
        Box(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(300.dp),
                    painter = currentImage.value,
                    contentDescription = "Art",
                    alignment = Alignment.Center
                )
            }

//            Column(
//
//            ) {
//                Text(text = "topic")
//                Row {
//                    Text(text = "author")
//                    Text(text = " ")
//                    Text(text = "year")
//                }
//            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {

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
                    currentImageIndex.value = (currentImageIndex.value + 1) % images.size;
                    Log.d("index", currentImageIndex.value.toString())
                    Log.d("size", images.size.toString())
                    currentImage.value = images[currentImageIndex.value];
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