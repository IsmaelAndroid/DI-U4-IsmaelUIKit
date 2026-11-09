package com.example.uikit

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

/** Pruebas del componente (criterio de evaluacion 3e): se comprueba lo que ve el usuario. */
class BadgeEstadoTest {

    @get:Rule
    val regla = createComposeRule()               // arranca un compose host en el dispositivo

    @Test
    fun muestraLaEtiquetaDeSuEstado() {
        regla.setContent { BadgeEstado(estado = Estado.OK) }
        regla.onNodeWithTag("badge_OK").assertIsDisplayed()      // existe y esta en pantalla
        regla.onNodeWithText("Completado").assertIsDisplayed()   // y pinta la etiqueta del estado
    }

    @Test
    fun elTextoPersonalizadoGanaALaEtiqueta() {
        regla.setContent { BadgeEstado(estado = Estado.ERROR, texto = "Caducado") }
        regla.onNodeWithText("Caducado").assertIsDisplayed()     // la propiedad texto manda
        regla.onNodeWithText("Fallido").assertDoesNotExist()     // y la etiqueta base desaparece
    }
}
