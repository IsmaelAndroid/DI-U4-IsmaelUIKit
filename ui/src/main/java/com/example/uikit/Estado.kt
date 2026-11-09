package com.example.uikit

import androidx.compose.ui.graphics.Color

/**
 * Los tres estados que sabe representar el kit.
 *
 * Es un `enum class` con datos: cada valor se construye con las **propiedades** que el
 * componente necesita para pintarse. Asi el color y el mensaje viajan *dentro* del estado
 * y no repartidos por las pantallas: cambiar el verde de "Completado" es tocar una linea.
 *
 * @param etiqueta texto que ve el usuario en el componente
 * @param acento color de referencia (punto, texto y borde) del estado
 * @param mensaje frase larga para los sitios donde el estado se explica, no se solo pinta
 */
enum class Estado(
    val etiqueta: String,
    val acento: Color,
    val mensaje: String,
) {
    OK("Completado", Color(0xFF1B5E20L), "Todo en orden"),
    AVISO("Revisa", Color(0xFFB26A00L), "Hay algo que conviene mirar"),
    ERROR("Fallido", Color(0xFFB00020L), "Algo no ha funcionado"),
}
