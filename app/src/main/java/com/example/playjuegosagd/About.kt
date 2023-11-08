package com.example.playjuegosagd

import android.content.res.Configuration
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun About() {
    //Slider

    var context = LocalContext.current
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {

            LazyColumn {


                items(getUser()) { lazy ->
                    ItemUser(lazyColumn = lazy)
                }
            }

        }


        else -> {

            LazyColumn {


                items(getUser()) { lazy ->
                    ItemUser(lazyColumn = lazy)
                }
            }

        }


    }

}


data class User(var user:String, var puntos:String, @DrawableRes var image :Int)

fun getUser(): List<User> {
    return listOf(
        User(
            "Maria Mata",
            "Puntos: 63786",
            R.drawable.image1
        ),
        User(
            "Antonio Sanz",
            "Puntos: 746",
            R.drawable.image2
        ),
        User(
            "Carlos Pérez",
            "Puntos: 876746",
            R.drawable.image3
        ),
        User(
            "Beatriz Martos",
            "Puntos: 456345",
            R.drawable.image4
        ),
        User(
            "Rodrigo Gimernez",
            "Puntos: 456436",
            R.drawable.image5
        ),
        User(
            "Pedro García",
            "Puntos: 456343",
            R.drawable.image6
        ),
        User(
            "Ramon Dopico",
            "Puntos: 54345",
            R.drawable.image7
        ),
        User(
            "Gimena Roto",
            "Puntos: 453643",
            R.drawable.image8
        ),
    )
}
@Composable
fun ItemUser(lazyColumn: User) {
    val peso = 1f
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                Toast //sale el mensaje de abajo
                    .makeText(
                        context,
                        lazyColumn.user,
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row (modifier = Modifier
            .weight(peso)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Image(
                painter = painterResource(id = lazyColumn.image),
                contentDescription = "Game Image",
                //modifier = Modifier.size(170.dp)
            )
        }

        Column (modifier = Modifier
            .weight(peso)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = lazyColumn.user)
            Text(text = lazyColumn.puntos)
        }
    }

}