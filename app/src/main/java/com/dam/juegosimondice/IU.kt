package com.dam.juegosimondice

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.juegosimondice.ui.theme.JuegoSimonDiceTheme

@Composable
fun InterfazUsuario(miViewModel: MyViewModel){
    //para que sea mas facil la etiqueta del log
    val TAG_LOG:String="Mensaje UI"

    SimonGameUI(miViewModel = MyViewModel())

}

@Composable
fun SimonGameUI(miViewModel: MyViewModel) {
    var isStarted by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cuadro de suma de rondas
        if(miViewModel.getContador()<10){
            Text("Rondas: ${miViewModel.getContador()}", modifier = Modifier.offset(x=100.dp))
        }else{
            Text("Rondas: ${miViewModel.getContador()}", modifier = Modifier.offset(x=100.dp), fontSize = 24.sp)
        }


        SequenceDisplay(miViewModel.sequence.value)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                ColorButton(SimonColor.RED)
                ColorButton(SimonColor.GREEN)
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                ColorButton(SimonColor.BLUE)
                ColorButton(SimonColor.YELLOW)
            }
        }
        Column(
            modifier = Modifier.padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Botón para iniciar o reiniciar el contador
                Button(
                    onClick = {
                        isStarted = !isStarted
                    },
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(if (isStarted) "Reset" else "Start")
                }

                // Botón para incrementar el contador
                Button(
                    onClick = { miViewModel.contadorClic() },
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
                        contentDescription = "Contador",
                        modifier = Modifier
                            .size(40.dp) // Ajusta el tamaño de la imagen según tus necesidades

                    )
                }
            }
        }

    }
}

@Composable
fun SequenceDisplay(sequence: List<SimonColor>) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(16.dp)
    ) {
        sequence.forEach { color ->
            ColorButton(color = color)
        }
    }
}

@Composable
fun ColorButton(color: SimonColor) {
    val colorValue = when (color) {
        SimonColor.RED -> Color.Red
        SimonColor.GREEN -> Color.Green
        SimonColor.BLUE -> Color.Blue
        SimonColor.YELLOW -> Color.Yellow
    }

    Button(
        onClick = { /* No se necesita hacer nada aquí */ },
        modifier = Modifier
            .size(100.dp)
            .background(colorValue)
            .padding(8.dp)
    ) {}
}

@Composable
fun ButtonRow(miViewModel: MyViewModel, onGameResult: (Boolean) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        ColorButton(SimonColor.RED)
        ColorButton(SimonColor.GREEN)
        ColorButton(SimonColor.BLUE)
        ColorButton(SimonColor.YELLOW)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JuegoSimonDiceTheme {
        InterfazUsuario(miViewModel = MyViewModel())
    }
}