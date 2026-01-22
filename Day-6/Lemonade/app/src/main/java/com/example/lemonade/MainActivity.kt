package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Lemonade",
                            fontSize = 28.sp,
                            textAlign = TextAlign.Center,
                            modifier= Modifier.background(Color.Gray).fillMaxWidth().padding(innerPadding)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Lemonade(
                            modifier = Modifier.fillMaxSize().padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Lemonade( modifier: Modifier = Modifier) {

    var squeezeCount by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(1) }
    var random by remember { mutableStateOf((3..5).random()) }
   when(result)
    {
        1-> {
            Column(modifier=modifier.clickable {
                if (result == 2) {
                    squeezeCount++
                    if (squeezeCount >= random) {
                        result = 3
                    }
                } else if(result==4){
                        result=1
                        squeezeCount=0
                        random=(3..5).random()
                }
                else {
                    result++
                }
            }, horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
              ) {
                Image(
                    painter = painterResource(R.drawable.l1),
                    contentDescription = stringResource(R.string.lemon_tree)
                )
                Text(
                    text = stringResource(R.string.lemon_tree)

                )
            }
        }
        2 ->{
            Column(modifier=modifier.clickable {
                if (result == 2) {
                    squeezeCount++
                    if (squeezeCount >= random) {
                        result = 3
                    }
                }
                else if(result==4){
                    result=1
                    squeezeCount=0
                    random=(3..5).random()
                }
                else {
                    result++
                }
            }, horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
               Image(
                   painter = painterResource(R.drawable.l2),
                   contentDescription = stringResource(R.string.lemon)
               )
                Text(
                    text = stringResource(R.string.lemon)
                )
            }
        }

       3 ->{
           Column(modifier=modifier.clickable{
               if(result==2)
               {
                   squeezeCount++
                   if(squeezeCount>=random)
                   {
                       result=3
                   }
               }
               else if(result==4){
                   result=1
                   squeezeCount=0
                   random=(3..5).random()
               }
               else{
                   result++
               }
           }, horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center) {
               Image(
                   painter = painterResource(R.drawable.l3),
                   contentDescription = stringResource(R.string.glass_of_lemonade)

               )
               Text(
                   text = stringResource(R.string.glass_of_lemonade)
               )
           }
       }
       4 ->{
           Column(modifier=modifier.clickable{
               if(result==2)
               {
                   squeezeCount++
                   if(squeezeCount>=random)
                   {
                       result=3
                   }

               }else if(result==4){
                   result=1
                   squeezeCount=0
                   random=(3..5).random()
               }
               else{
                   result++
               }
           }, horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center) {
               Image(
                   painter = painterResource(R.drawable.l4),
                   contentDescription = stringResource(R.string.empty_glass)
               )
               Text(
                   text = stringResource(R.string.empty_glass)
               )
           }
       }

    }


}

@Preview
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}