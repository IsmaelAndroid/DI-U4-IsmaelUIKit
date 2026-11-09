# IsmaelUIKit: proyecto 1 (el componente)

Proyecto de ejemplo de **DI · U4.1 Creación de componentes**, apartado
**8.1 Llevar el componente a otro proyecto, paso a paso**.

Contiene un kit de componentes Jetpack Compose en un **módulo de librería** (`:ui`) y una
app de demostración (`:app`) que lo usa con `implementation(project(":ui"))`.

```
IsmaelUIKit/
├── app/   app de demostración (catálogo de componentes)
└── ui/    módulo de librería: genera el .aar
    └── src/main/java/com/example/uikit/
        ├── Estado.kt        enum con color, etiqueta y mensaje
        ├── BadgeEstado.kt   el componente que se lleva al otro proyecto
        └── SelectorMes.kt   componente con evento (onSeleccion)
```

## Generar el AAR

Desde la raíz del proyecto:

```bash
./gradlew :ui:assembleRelease
```

Salida: `ui/build/outputs/aar/ui-release.aar`.

Ese fichero se copia a `app/libs/` del proyecto que lo va a usar
(ver [DI-U4-OtraAplicacion](https://github.com/IsmaelAndroid/DI-U4-OtraAplicacion)).

## Requisitos

Android Studio con AGP 9.1, Gradle 9.5 y SDK de Android API 37.
