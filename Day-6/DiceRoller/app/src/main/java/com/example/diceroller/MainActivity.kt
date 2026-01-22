    package com.example.diceroller

    import android.os.Bundle
    import androidx.compose.material3.Button
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.wrapContentSize
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.tooling.preview.Preview
    import com.example.diceroller.ui.theme.DiceRollerTheme
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.unit.dp
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.modifier.modifierLocalOf
    import androidx.compose.ui.unit.sp

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                DiceRollerTheme {
                    Scaffold(modifier = Modifier.fillMaxSize(), contentColor = Color.White) { innerPadding ->
                        DiceRollerApp(modifier= Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color.White)
                            .wrapContentSize(Alignment.Center),
                        )
                    }
                }
            }
        }
    }
    @Composable
    fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
        var result by remember { mutableStateOf(1) }
        val imageResource = when(result) {
            1-> R.drawable.diceone
            2->R.drawable.dicetwo
            3->R.drawable.dicethree
            4->R.drawable.dicefour
            5->R.drawable.dicefive
            else->R.drawable.dicesix
        }

        Column(modifier=modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier= Modifier.size(200.dp)

            )
            Spacer(modifier= Modifier.height(16.dp))
       Button(onClick = { result = (1..6).random()}
          ) {

           Text(stringResource(R.string.roll)
               ,fontSize = 24.sp)


       }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DiceRollerApp(modifier: Modifier= Modifier) {
        DiceRollerTheme {
            DiceWithButtonAndImage(modifier)
        }
    }