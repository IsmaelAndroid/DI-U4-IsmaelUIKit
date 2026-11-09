package com.example.uikit.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.BadgeEstado
import com.example.uikit.Estado
import com.example.uikit.SelectorMes

/** Catalogo del kit: ensena cada componente del modulo :ui con sus variantes. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(Modifier.fillMaxSize()) { Catalogo() }
            }
        }
    }
}

@Composable
fun Catalogo() {
    var mes by rememberSaveable { mutableStateOf<Int?>(null) }
    Column(
        Modifier.safeDrawingPadding().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Text("IsmaelUIKit · catalogo", style = MaterialTheme.typography.headlineSmall)
        Text("Componentes del modulo :ui (proyecto 1)", style = MaterialTheme.typography.bodyMedium)
        HorizontalDivider()

        Text("BadgeEstado", style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BadgeEstado(Estado.OK)
            BadgeEstado(Estado.AVISO)
            BadgeEstado(Estado.ERROR)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BadgeEstado(Estado.ERROR, texto = "Caducado")
            BadgeEstado(Estado.OK, conPunto = false)
        }
        HorizontalDivider()

        Text("SelectorMes", style = MaterialTheme.typography.titleMedium)
        SelectorMes(mesSeleccionado = mes, onSeleccion = { mes = it })
        Text("Mes elegido: " + (mes?.toString() ?: "ninguno"))
    }
}

@Preview(showBackground = true)
@Composable
private fun VistaPreviaCatalogo() {
    MaterialTheme { Catalogo() }
}
