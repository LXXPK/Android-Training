package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   FinalScreen()
                }
            }
        }
    }
}

@Composable
fun TopSection(modifier: Modifier) {

    val img = painterResource(R.drawable.androidimg)
    Column( horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = img,
            contentDescription = null,
            modifier.width(300.dp).height(200.dp)


        )
        Text(
            text = "NAME",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = "title",

        )
    }

}
@Composable
fun ContactSection( modifier: Modifier = Modifier) {
    Column(modifier.padding(26.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "+91 1234567891",
         fontSize = 20.sp,


        )
        Text(
            text = "hello@gmail.com",
            fontSize = 20.sp,

        )
        Text(
            text = "@KumarSocialMedia",
            fontSize = 20.sp,

        )
    }
}

@Composable
fun FinalScreen()
{
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        TopSection(Modifier)
        ContactSection(Modifier)

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        FinalScreen()
    }
}