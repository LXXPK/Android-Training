    package com.example.artwork

    import android.graphics.Color.rgb
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.annotation.StringRes
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
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
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.modifier.modifierLocalConsumer
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.example.artwork.ui.theme.ArtWorkTheme


    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                ArtWorkTheme {
                    var res by remember { mutableStateOf(1) }
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        when(res)
                       {
                           1-> AppLayout(
                               img=R.drawable.pc,
                               title=R.string.art1,
                               desc=R.string.art1desc,
                               onNext = {res=2},
                               onPrevious = {},
                               modifier= Modifier.padding(innerPadding)
                           )
                            2-> AppLayout(
                                img=R.drawable.pc2,
                                title=R.string.art2,
                                desc=R.string.art2desc,
                                onNext = {res=3},
                                onPrevious = {res=1},
                                modifier= Modifier.padding(innerPadding)
                            )
                            3-> AppLayout(
                                img=R.drawable.pc3,
                                title=R.string.art3,
                                desc=R.string.art3desc,
                                onNext = {res=1},
                                onPrevious = {res=2},
                                modifier= Modifier.padding(innerPadding)
                            )

                       }
                    }
                }
            }
        }
    }

    @Composable
    fun AppLayout(
        img:Int,
        @StringRes title:Int,
        onNext:()->Unit,
        onPrevious:()->Unit,
        @StringRes desc: Int, modifier: Modifier = Modifier) {

        Column(modifier.padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(32.dp))
            Image(
    painter = painterResource(img),
                contentDescription = null,
                modifier= Modifier
                    .shadow(12.dp,RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .size(500.dp)
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)


            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(rgb(236 ,235 ,244)))
                    .padding(18.dp)
                  ,
                horizontalAlignment = Alignment.CenterHorizontally,


            ) {
                Text(
                    text = stringResource(title),
                    fontSize = 32.sp,


                )
                Text(
                    text = stringResource(desc),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Row(
                modifier=Modifier.padding(16.dp).fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Button(onClick =onPrevious ) {
                    Text(stringResource(R.string.previous), fontSize=18.sp)

                }
                Button(onClick = onNext) {
                    Text(stringResource(R.string.next), fontSize = 18.sp)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ArtWorkTheme {
            AppLayout(
                img=R.drawable.pc,
                title=R.string.art1,
                desc=R.string.art1desc,
                onNext = {},
                onPrevious = {},
                modifier= Modifier
            )
        }
    }