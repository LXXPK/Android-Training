package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    GreetingScreen()
                }
            }
        }
    }
}



@Composable
fun GreetingText(message: String, from:String, modifier: Modifier= Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=modifier.fillMaxSize()) {
        Text(
            text = message,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontSize = 95.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = from,
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Magenta,
            modifier=modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}


@Composable
fun GreetingImage( modifier: Modifier= Modifier)
{
val image = painterResource(R.drawable.party)

    Image(
        painter = image,
        contentDescription = null,
        modifier=modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )
}

@Composable
fun GreetingScreen()
{
    Box(modifier= Modifier.fillMaxSize()){
        GreetingImage(modifier = Modifier.fillMaxSize())
        GreetingText(message="Happy Birthday Kumar",
            from="From Ram",
            modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingScreen()
    }
}