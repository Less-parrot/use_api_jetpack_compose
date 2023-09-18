package com.example.use_api_jetpack_compose.confi_use_api

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.use_api_jetpack_compose.api_models.models_nasa.nasa
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ShowTextAPI(applicationContext: Context) {
    val retroftiTraer = RetrofitClient.consumirApi.getTraer()
    val TextoAPI = remember { mutableStateOf("") }

    // Usar LaunchedEffect para realizar la llamada a la API de forma asincrónica
    LaunchedEffect(key1 = retroftiTraer) {
        retroftiTraer.enqueue(object : Callback<nasa> {
            override fun onResponse(call: Call<nasa>, response: Response<nasa>) {
                val texto = response.body().toString()
                TextoAPI.value = texto//Mandamos el nuevo Texto a la variable TextoAPI
            }

            override fun onFailure(call: Call<nasa>, t: Throwable) {
                /*Si no se conecta a la API, mostrar un
                mensaje emergente de que no se pudo conectar*/
                Toast.makeText(
                    applicationContext,
                    "Conexión fallida, intentelo más tarde",
                    Toast.LENGTH_SHORT
                ).show()
                TextoAPI.value = ""//Mandamos un string vacio a la variable TextoAPI
            }
        })
    }
    //hacemos un Scroll para poder mirar todo el texto plano
    Column(Modifier.verticalScroll(ScrollState(0))) {
        Text(text = TextoAPI.value,//Mostramos Toda la respuesta la de API en texto plano
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp)//ponemos tamaño a la letra
    }
}

