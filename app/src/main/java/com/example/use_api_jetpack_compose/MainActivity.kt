package com.example.use_api_jetpack_compose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.use_api_jetpack_compose.confi_use_api.ShowTextAPI
import com.example.use_api_jetpack_compose.ui.theme.Use_api_jetpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(applicationContext = applicationContext)
        }
    }
}


@Composable
fun MainScreen(applicationContext: Context) {
    Use_api_jetpack_composeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Red
        ) {
            //Hacemos un cuadro, con 30 pixeles de densidad y un fondo de color blacnco
            Box(Modifier.fillMaxSize().padding(30.dp).background(color = Color.White)) {
                //Llamamos a la función para mostrar por pantalla el texto de la API
                ShowTextAPI(applicationContext = applicationContext)
            }
        }
    }
}
