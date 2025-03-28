# 📦 Sistema de Gestión de Inventario en Kotlin

Este proyecto es una aplicación de consola desarrollada en **Kotlin** que permite gestionar un inventario de productos. El sistema permite realizar operaciones como agregar, consultar, modificar y eliminar productos, además de calcular el IVA total del inventario.

## 🛠️ Funcionalidades

- Agregar productos al inventario
- Consultar todos los productos registrados
- Modificar información de un producto por ID
- Eliminar productos del inventario por ID
- Calcular el IVA total del inventario (19%)

## Estructura del Proyecto

### `Producto.kt`

Contiene la clase `Producto`, que representa un producto del inventario con:

- ID
- Nombre
- Cantidad
- Precio unitario  
Además, permite calcular:
- Precio total (cantidad × precio)
- IVA (19% del precio total)

### `Inventario.kt`

Contiene la clase `Inventario`, que gestiona una lista mutable de productos y ofrece métodos para:

- Agregar, consultar, modificar y eliminar productos
- Calcular el IVA total del inventario

### `Main.kt`

Contiene la función `main()` que presenta un menú interactivo para que el usuario interactúe con el invent

## Autores

- Juan Camilo Lozano Cortes
- Julio Flores Guarnizo
- Maria Parra
- Andres Espitia
