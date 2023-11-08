package com.example.playjuegosagd

import android.content.res.Configuration
import android.media.Image
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.playjuegosagd.ui.theme.Blue20
import com.example.playjuegosagd.ui.theme.TransPurple

@Composable
fun Play() {
    //Slider
    val myOptions = getOptions(listOf(
        "Angry Birds",
        "Dragon Fly",
        "Hill Climbing Racing",
        "Radiant Defense",
        "Pocket Soccer",
        "Ninja Jump",
        "Air Control"))

    val noSelection = myOptions.none { it.selected }
    var context = LocalContext.current
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(20.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "Elige una opción"
                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {

                }


            }
            Box (Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
                FloatingActionButton(
                    onClick = {
                        if (noSelection) {
                            Toast.makeText(
                                context,
                                "No has pulsado ninguna opcion",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            val selectedOptions = myOptions.filter { it.selected }
                            val message = "Has seleccionado ${selectedOptions.joinToString { it.title }}"
                            Toast.makeText(
                                context, message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    },
                    shape = CircleShape,
                    containerColor = Blue20,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(50.dp)
                        .width(50.dp))
                {

                    Icon(imageVector = Icons.Filled.Check, contentDescription = "check" )
                }

            }
        }


        else -> {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.size(15.dp))
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {


                    Row (){
                        Column() {
                            myOptions.forEach {
                                MyCheckBox(it)
                            }
                        }
                    }


                }




            }
            Box (Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
                FloatingActionButton(
                    onClick = {
                        if (noSelection) {
                            Toast.makeText(
                                context,
                                "No has pulsado ninguna opcion",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            val selectedOptions = myOptions.filter { it.selected }
                            val message = "Has seleccionado ${selectedOptions.joinToString { it.title }}"
                            Toast.makeText(
                                context, message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    },
                    shape = CircleShape,
                    containerColor = Blue20,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .height(50.dp)
                        .width(50.dp))
                {

                    Icon(imageVector = Icons.Filled.Check, contentDescription = "check" )
                }

            }
        }

    }

}


data class CheckInfo(var title:String, var selected:Boolean, var onCheckedChange:(Boolean)->Unit, @DrawableRes var image :Int)

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var estadoCheck by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = estadoCheck,
            onCheckedChange = { estadoCheck = it },
            image = 0
        )
    }
}
@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),

        )
    {
        Row() {
            when(checkInfo.title){
                "Angry Birds" ->checkInfo.image = R.drawable.games_aircontrol
                "Dragon Fly" -> checkInfo.image = R.drawable.games_dragonfly
                "Hill Climbing Racing" -> checkInfo.image = R.drawable.games_hillclimbingracing
                "Radiant Defense" -> checkInfo.image = R.drawable.games_radiantdefense
                "Pocket Soccer" -> checkInfo.image = R.drawable.games_pocketsoccer
                "Ninja Jump" -> checkInfo.image = R.drawable.games_ninjump
                "Air Control" -> checkInfo.image = R.drawable.games_aircontrol
            }
            androidx.compose.foundation.Image(painter = painterResource(id = checkInfo.image), contentDescription = checkInfo.title, Modifier.size(70.dp))
            Checkbox(
                checked = checkInfo.selected,
                onCheckedChange = {
                    checkInfo.onCheckedChange(!checkInfo.selected) })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = checkInfo.title, Modifier.padding(top = 12.dp))
        }


    }
}