package com.dam.juegosimondice

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class SimonColor {
    RED, GREEN, BLUE, YELLOW
}
/**
 * Inicializa y modifica los datos de la app
 */
class MyViewModel() : ViewModel() {
    //para que sea mas facil la etiqueta del log
    private val TAG_LOG: String = "Mensaje ViewModel"

    // Variable para almacenar el resultado del juego
    private val _gameResult = mutableStateOf(false)
    val gameResult: State<Boolean> = _gameResult

    // Variable para almacenar la secuencia
    val sequence = mutableStateListOf<SimonColor>()

    // Variable para almacenar la secuencia ingresada por el jugador
    private val _playerSequence = mutableStateOf(mutableListOf<SimonColor>())
    val playerSequence: State<List<SimonColor>> = _playerSequence

    var counter=mutableStateOf(0)

    //inicializamos variables cuando instanciamos, éste es el constructor de la clase
    init {
        //se usa el log para saber cuando se ejecuta la instacia de la clase
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    /**
     * Contador de clic
     */
    fun contadorClic(){
        counter.value++
    }

    /**
     * Crear contador
     */
    fun getContador():Int{
        return counter.value
    }

    // Función para generar una secuencia aleatoria
    fun generarSecuencia() {
        sequence.clear()
        for (i in 1..10) {  // Genera una secuencia de 10 elementos
            val randomColor = SimonColor.values().random()
            sequence.add(randomColor)
        }
    }
}