package com.example.uikit

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

/** Los doce meses: la lista es una propiedad mas, se puede sustituir por otro calendario. */
val MESES = listOf(
    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre",
)

/**
 * Componente: desplegable de meses con estado interno.
 *
 * Aqui el componente se guarda solo si esta abierto el menu (estado interno) y **avisa**
 * al exterior por un evento: `onSeleccion`, la pareja moderna de "asociar acciones al evento".
 *
 * @param mesSeleccionado 1..12: el control es "controlado", manda quien nos usa
 * @param onSeleccion evento: se dispara con el numero de mes cuando el usuario elige uno
 * @param modifier posicion y tamano decididos por la pantalla
 * @param textoVacio etiqueta del boton cuando aun no hay eleccion
 */
@Composable
fun SelectorMes(
    mesSeleccionado: Int?,
    onSeleccion: (Int) -> Unit,
    modifier: Modifier = Modifier,
    textoVacio: String = "Elige un mes",
) {
    var abierto by remember { mutableIntStateOf(0) }   // 0 = cerrado, 1 = abierto (estado interno)
    Box(modifier) {
        OutlinedButton(
            onClick = { abierto = 1 },                  // evento de apertura
            modifier = Modifier.testTag("selector_mes"),
        ) {
            Text(mesSeleccionado?.let { MESES[it - 1] } ?: textoVacio)
        }
        DropdownMenu(expanded = abierto == 1, onDismissRequest = { abierto = 0 }) {
            MESES.forEachIndexed { indice, nombre ->
                DropdownMenuItem(
                    text = { Text(nombre) },
                    onClick = {                          // el evento propaga el numero, no el nombre:
                        abierto = 0                      // la pantalla decide que hacer con el mes
                        onSeleccion(indice + 1)
                    },
                    trailingIcon = if (indice + 1 == mesSeleccionado) {
                        { Text("ok") }                   // marca la opcion activa
                    } else {
                        null
                    },
                )
            }
        }
    }
}

@Preview(name = "SelectorMes · sin elegir", showBackground = true)
@Composable
private fun VistaPreviaSelectorVacio() {
    SelectorMes(mesSeleccionado = null, onSeleccion = {})
}

@Preview(name = "SelectorMes · con eleccion", showBackground = true)
@Composable
private fun VistaPreviaSelectorElegido() {
    SelectorMes(mesSeleccionado = 3, onSeleccion = {})
}
