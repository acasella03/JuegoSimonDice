package com.dam.juegosimondice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dam.juegosimondice.ui.theme.JuegoSimonDiceTheme

val TAG: String = "Estado"


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializamos ViewModel
        val miViewModel:MyViewModel=MyViewModel()
        setContent {
            JuegoSimonDiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    //Greeting(NAME)
                    InterfazUsuario(miViewModel)
                }

            }
        }
        Log.d(TAG, "onCreate")

        /*calcular(a = 3, b = 5, fun() {
            //val suma = numero1 + numero2
            //Log.d("calcular", suma.toString())
        })

        /*
        Esto es una función que ya tiene parámetros predefinidos
        y una termina con función vacía como parámetro

        fun calcular(a: Int = 0, b: Int = 0, operacion: () -> Unit) {
        operacion()
         */
        calcular {
            Log.d("calcular", "yo no hago nada, solo LOG")
        }*/
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    /*fun calcular(a: Int = 0, b: Int = 0, operacion: () -> Unit) {
        //val operacion = a + b
        //Log.d("calcular", operacion.toString())
        //operacion(a, b)
        operacion()
    }*/
}

// Declara tu función para generar números aleatorios
/*fun generarNumeroAleatorio(): Int {
    return (0..10).random()
}*/