package com.example.task3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task3.ui.theme.Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    FinalScreen()

                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, content:String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(modifier=modifier.fillMaxSize().background(backgroundColor).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold
            )
        Text(
            text = content,
            textAlign = TextAlign.Justify
            )
    }

}

@Composable
fun FinalScreen()
{
    Column(modifier= Modifier.fillMaxSize()) {
        Row(modifier= Modifier.weight(1f)) {
            Greeting("Text composable","Displays text and follows the recommended Material Design guidelines.",Color(0xFFEADDFF),
                Modifier.weight(1f))
            Greeting("Image composable","Creates a composable that lays out and draws a given Painter class object.",Color(0xFFD0BCFF),
                Modifier.weight(1f))
        }
        Row(modifier=Modifier.weight(1f)) {
            Greeting("Row composable","A layout composable that places its children in a horizontal sequence.",Color(0xFFB69DF8),
                Modifier.weight(1f))
            Greeting("Column composable","A layout composable that places its children in a vertical sequence.",Color(0xFFF6EDFF),
                Modifier.weight(1f))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task3Theme {
        FinalScreen()
    }
}