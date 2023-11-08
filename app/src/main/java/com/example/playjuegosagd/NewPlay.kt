package com.example.playjuegosagd

import android.annotation.SuppressLint
import android.content.res.Configuration
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

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playjuegosagd.ui.theme.Blue20
import com.example.playjuegosagd.ui.theme.TransPurple


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPlayer() {
    var nom by remember{ mutableStateOf("")}
    var apellido by remember{ mutableStateOf("") }
    var nickname by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var errorTextName by remember{ mutableStateOf("*Obligatorio") }
    var errorTextNickname by remember{ mutableStateOf("*Obligatorio") }
    var peso1 = 1f
    var peso2 = 2f
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
                        .height(60.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account),
                        contentDescription = "AccountImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    TextField(
                        value = nom,
                        onValueChange = {nom = it},
                        modifier = Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Nombre")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Row(Modifier.height(20.dp)) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Text(
                        text = errorTextName,
                        modifier = Modifier
                            .weight(peso2)
                            .padding(start = 15.dp),
                        if(errorTextName.equals("Error: Obligatorio")){
                            Color.Red
                        }else{
                            Color.Black
                        },
                        fontSize = 12.sp
                    )
                }

                Row {
                    Spacer(modifier = Modifier.weight(peso1))
                    TextField(
                        value = apellido,
                        onValueChange = {apellido = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Apellidos")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row {
                    Spacer(modifier = Modifier.weight(peso1))
                    TextField(
                        value = nickname,
                        onValueChange = {nickname = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Nickname")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Row(Modifier.height(20.dp)) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Text(
                        text = errorTextNickname,
                        modifier = Modifier
                            .weight(peso2)
                            .padding(start = 15.dp),
                        if(errorTextNickname.equals("Error: Obligatorio")){
                            Color.Red
                        }else{
                            Color.Black
                             },
                        fontSize = 12.sp
                    )
                }
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Image(
                        painter = painterResource(id = R.drawable.android),
                        contentDescription = "Android Icon",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize(),
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(peso1)
                            .padding(end = 35.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Blue20)
                    ) {
                        Text(text = "Change")
                    }
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "CameraImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    TextField(
                        value = "Telefono",
                        onValueChange = {},

                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "EmailImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    TextField(
                        value = email,
                        onValueChange = {email = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Email")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { if(nom.isEmpty() && nickname.isEmpty()){
                        errorTextName = "Error: Obligatorio"
                        errorTextNickname = "Error: Obligatorio"
                    }else if(nickname.isEmpty() && !nom.isEmpty()){
                        errorTextNickname = "Error: Obligatorio"
                        errorTextName = "Listo"
                    }else if(!nickname.isEmpty() && nom.isEmpty()){
                        errorTextNickname = "Listo"
                        errorTextName = "Error: Obligatorio"
                    }else{
                        errorTextName = "Listo"
                        errorTextNickname = "Listo"
                    } }) {
                        Text(text = "Add new player")

                    }
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
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account),
                        contentDescription = "AccountImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    TextField(
                        value = nom,
                        onValueChange = {nom = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Nombre")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Row(Modifier.height(20.dp)) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Text(
                        text = errorTextName,
                        modifier = Modifier
                            .weight(peso2)
                            .padding(start = 15.dp),
                        if(errorTextName.equals("Error: Obligatorio")){
                            Color.Red
                        }else{
                            Color.Black
                        },
                        fontSize = 12.sp
                    )
                }
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()

                ) {
                    Spacer(modifier = Modifier.weight(peso1))
                    TextField(
                        value = apellido,
                        onValueChange = {apellido = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Apellidos")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()

                ) {
                    Spacer(modifier = Modifier.weight(peso1))
                    TextField(
                        value = nickname,
                        onValueChange = {nickname = it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Nickname")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Row(Modifier.height(20.dp)) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Text(
                        text = errorTextNickname,
                        modifier = Modifier
                            .weight(peso2)
                            .padding(start = 15.dp),
                        if(errorTextNickname.equals("Error: Obligatorio")){
                            Color.Red
                        }else{
                            Color.Black
                        },
                        fontSize = 12.sp
                    )
                }
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(peso1))
                    Image(
                        painter = painterResource(id = R.drawable.android),
                        contentDescription = "Android Icon",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize(),
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(peso1)
                            .padding(end = 35.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Blue20)
                    ) {
                        Text(text = "Change")
                    }
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "CameraImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    /*TextField(
                        value = "Telefono",
                        onValueChange = {},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Telefono")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )*/
                    Column (Modifier.weight(2f).padding(end = 10.dp)){
                        MyDropDownMenu()
                    }

                }
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    Modifier
                        .height(60.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.email),
                        contentDescription = "EmailImage",
                        Modifier
                            .weight(peso1)
                            .fillMaxSize()
                    )
                    TextField(
                        value = email,
                        onValueChange = {email =it},
                        Modifier
                            .weight(peso2)
                            .padding(end = 10.dp),
                        label = { Text(text = "Email")},
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = TransPurple,
                            focusedIndicatorColor = Blue20
                        )
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Row (modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.Center)
                {
                    Button(onClick = {
                        if(nom.isEmpty() && nickname.isEmpty()){
                        errorTextName = "Error: Obligatorio"
                        errorTextNickname = "Error: Obligatorio"
                    }else if(nickname.isEmpty() && !nom.isEmpty()){
                        errorTextNickname = "Error: Obligatorio"
                        errorTextName = "Listo"
                    }else if(!nickname.isEmpty() && nom.isEmpty()){
                        errorTextNickname = "Listo"
                        errorTextName = "Error: Obligatorio"
                    }else{
                        errorTextName = "Listo"
                        errorTextNickname = "Listo"
                    } }) {
                        Text(text = "Add new player")

                    }
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val telefonos =
        listOf("600006066", "60003403403", "9054684534", "5674666665", "46466766464")
                Column() {
            OutlinedTextField(value = selectedText, onValueChange = {
                selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true },
                label = { Text(text = "Telefono")},
                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = TransPurple,
                    focusedIndicatorColor = Blue20
                )
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                telefonos.forEach { telefono ->
                    DropdownMenuItem(text = { Text(text = telefono)},
                        onClick = {selectedText = telefono
                        expanded = false})
                }
            }
        }
}


