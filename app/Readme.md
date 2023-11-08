# Simon Dice - Juego de Memoria

## Descripción

El juego "Simón dice" es un juego de memoria en el que los jugadores deben repetir una secuencia de colores y sonidos que se les presenta. El juego se vuelve más difícil a medida que avanza, ya que la secuencia se alarga. El objetivo es recordar y repetir la secuencia correctamente para avanzar en el juego.

## Cómo Jugar

1. El juego consta de cuatro colores: rojo, verde, azul y amarillo.
2. Simon comenzará mostrando una secuencia de colores aleatorios y emitiendo un sonido para cada color.
3. El jugador debe repetir la secuencia tocando los colores en el mismo orden en que se mostraron.
4. Si el jugador reproduce la secuencia correctamente, avanza al siguiente nivel, que agrega un color a la secuencia.
5. Si el jugador comete un error, el juego termina y se muestra la puntuación obtenida.

## Diagrama de Flujo

A continuación, se presenta un diagrama de flujo que muestra cómo funciona el juego:

```mermaid
graph TD;
Inicio-->Simon muestra una secuencia
Simon muestra una secuencia-->Espera entrada del jugador
Espera entrada del jugador--Respuesta correcta-->Aumenta la longitud de la secuencia
Espera entrada del jugador--Respuesta incorrecta-->Fin del juego
Fin del juego-->Mostrar puntuación
Mostrar puntuación-->Fin
```