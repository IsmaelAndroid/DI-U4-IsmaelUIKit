package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Componente: chivato de estado con punto de color y texto.
 *
 * Cada parametro es una **propiedad** del componente: valores por defecto incluidos,
 * para que quien nos llame pueda quedarse solo con lo obligatorio.
 *
 * @param estado unico dato obligatorio: de el salen color, punto y texto por defecto
 * @param texto permite sustituir la etiqueta del estado sin crear otro componente
 * @param modifier hereda la posicion y el tamano que decida quien nos llama
 * @param conPunto apaga el punto de color para las listas donde ya sobra
 * @param relleno color de fondo; por defecto el acento del estado al 15% de opacidad
 */
@Composable
fun BadgeEstado(
    estado: Estado,
    texto: String = estado.etiqueta,
    modifier: Modifier = Modifier,
    conPunto: Boolean = true,
    relleno: Color = estado.acento.copy(alpha = 0.15f),
) {
    Row(
        modifier = modifier
            .testTag("badge_" + estado.name)          // nombre estable para las pruebas
            .clip(RoundedCornerShape(percent = 50))    // recorte en "pastilla": esquinas al 50%
            .background(relleno)                       // fondo del color del estado, apagado
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically, // punto y texto, centrados en su fila
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (conPunto) {
            Box(
                Modifier
                    .size(10.dp)                       // diametro del punto
                    .clip(CircleShape)                 // caja cuadrada -> circulo
                    .background(estado.acento),        // el color puro del estado
            )
        }
        Text(
            text = texto,
            color = estado.acento,
            style = MaterialTheme.typography.labelLarge, // la tipografia la decide el tema, no el componente
        )
    }
}

/** Documentacion viva: la propia pantalla de diseno ensena como se ve el componente. */
@Preview(name = "BadgeEstado · tres estados", showBackground = true)
@Composable
private fun VistaPreviaBadge() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        BadgeEstado(estado = Estado.OK)
        BadgeEstado(estado = Estado.AVISO)
        BadgeEstado(estado = Estado.ERROR, conPunto = false)
    }
}
