package com.example.exe1_pam_118

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun UCP(
    modifier: Modifier = Modifier
) {

    var Email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var thnmasuk by remember { mutableStateOf("") }

    var tahunmasuk = listOf("2020", "2021", "2022")

    var ConfEmail by remember { mutableStateOf("") }
    var Confalamat by remember { mutableStateOf("") }
    var Confnotelepon by remember { mutableStateOf("") }
    var Confthnmasuk by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TAMPILAN()
        header()

        TextField(
            value = Email,
            onValueChange = { Email = it },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi Email Anda")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = {
                Text(text = "notelepon")
            },
            placeholder = {
                Text(text = "Isi notelepon Anda")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = {
                Text(text = "alamat")
            },
            placeholder = {
                Text(text = "Isi alamat Anda")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Text(text = "Tahun Masuk:")

        Row(modifier = Modifier.fillMaxWidth()) {
            tahunmasuk.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = thnmasuk == selectedGender,
                        onClick = { thnmasuk = selectedGender }
                    )
                    Text(text = selectedGender, modifier = Modifier, Color.Blue)
                }
            }

        }

        Button(onClick = {
            ConfEmail = Email
            Confalamat = alamat
            Confnotelepon = notelepon
            Confthnmasuk = thnmasuk
        }) {
            Text(text = "Simpan")
        }
        Text(text = "Data Kamu")
        pendaftaran(
            para = "Email",
            arg = ConfEmail
        )
        pendaftaran(
            para = "Phone",
            arg = Confnotelepon
        )
        pendaftaran(
            para = "Address",
            arg = Confalamat
        )
        pendaftaran(
            para = "Year",
            arg = Confthnmasuk
        )


    }
}

@Composable
fun header(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(text = "Masukkan Biodata Kamu!")
        Text(text = "Silahkan Isi Data dengan sebenar-benarnya")

    }
}


@Composable
fun TAMPILAN() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dimas),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
            ) {
                Text(text = "Halo,")
                Text(text = "Dhimas Aditya Pratama")
            }


            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(5.dp),
                tint = Color.White
            )
        }
    }
}


@Composable
fun pendaftaran(
    para: String, arg: String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = para, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.1f))
            Text(text = arg, modifier = Modifier.weight(2f))
        }
    }
}