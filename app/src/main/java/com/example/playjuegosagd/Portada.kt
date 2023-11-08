package com.example.playjuegosagd

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.playjuegosagd.R
import com.example.playjuegosagd.ui.theme.FontTitle


/*@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.playJuegos),
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier =  modifier
    )

    Spacer(modifier = Modifier.size(50.dp))

    Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
        Text(text = "Play")
    }
    Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
        Text(text = "New Play")
    }
    Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
        Text(text = "Preferences")
    }
    Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {
        Text(text = "About")
    }
}*/

@Composable
fun Portada( navController: NavHostController){

        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Spacer(modifier = Modifier.size(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "EmailImage",
                        Modifier.width(50.dp).height(50.dp)
                        )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = stringResource(id = R.string.playJuegos),
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontTitle

                    )

                    Spacer(modifier = Modifier.size(50.dp))
                    Row{
                        Button(onClick = {}, modifier = Modifier.width(200.dp).padding(15.dp,0.dp)) {
                            Text(text = "Play")
                        }
                        Button(onClick = { navController.navigate("NewPlayer") }, modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                            Text(text = "New Play")
                        }
                    }
                    Row{
                        Button(onClick = { navController.navigate("Preferences")},modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                        Text(text = "Preferences")
                    }
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp).padding(15.dp, 0.dp)) {
                        Text(text = "About")
                    }
                    }
                }
            }

            else -> {
                Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "EmailImage",
                        Modifier.width(80.dp).height(80.dp)

                    )
                    Spacer(modifier = Modifier.size(50.dp))
                    Text(
                        text = stringResource(id = R.string.playJuegos),
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontTitle
                    )

                    Spacer(modifier = Modifier.size(50.dp))

                    Button(onClick = { navController.navigate("Play") }, modifier = Modifier.width(200.dp)) {
                        Text(text = "Play")
                    }
                    Button(onClick = {navController.navigate("NewPlayer")  }, modifier = Modifier.width(200.dp)) {
                        Text(text = "New Play")
                    }
                    Button(onClick = { navController.navigate("Preferences") }, modifier = Modifier.width(200.dp)) {
                        Text(text = "Preferences")
                    }
                    Button(onClick = { navController.navigate("About")  }, modifier = Modifier.width(200.dp)) {
                        Text(text = "About")
                    }
                }
            }
        }

}


