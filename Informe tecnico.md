# Informe Detallado del Sistema de Gestión de Inventario en Kotlin

## 1. Introducción

Este proyecto consiste en el desarrollo de un sistema de **gestión de inventario** utilizando el lenguaje de programación **Kotlin**, ejecutado en consola. Su propósito es facilitar la administración de productos mediante funcionalidades CRUD (Crear, Leer, Actualizar y Eliminar), además del cálculo automático del IVA tanto individual como total del inventario.

Este informe describe detalladamente el diseño del sistema, su estructura de clases, lógica funcional y validaciones implementadas.

---

## 2. Objetivos

### 2.1 Objetivo General

Desarrollar un sistema interactivo y funcional en consola, utilizando Kotlin, que permita llevar un control preciso de productos en inventario, aplicando conceptos de programación orientada a objetos.

### 2.2 Objetivos Específicos

- Implementar clases con encapsulamiento de datos.
- Realizar operaciones CRUD sobre productos.
- Calcular automáticamente el IVA del producto y del inventario completo.
- Garantizar robustez mediante validación de entradas.
- Simular una interfaz por consola para interacción con el usuario.

---

## 3. Tecnologías Utilizadas

- **Lenguaje de programación:** Kotlin
- **Entorno de ejecución:** Consola (línea de comandos)
- **Paradigma:** Programación Orientada a Objetos (POO)
- **Interacción:** Entrada y salida estándar con `readLine()` y `println()`

---

## 4. Diseño del Sistema

El diseño está basado en dos entidades principales:

- **Producto:** modelo individual de cada elemento en inventario.
- **Inventario:** colección dinámica de productos, con lógica de gestión.

El control del flujo está dado por la función `main()`, que despliega un menú interactivo.

### 4.1 Clase `Producto`

La clase `Producto` encapsula los datos esenciales de un artículo:

- `id: Int` → Identificador único del producto.
- `nombre: String` → Nombre del producto.
- `cantidad: Int` → Cantidad disponible en el inventario.
- `precio: Double` → Precio unitario sin IVA.

#### Métodos definidos:

- `getId()`, `getNombre()`, `getCantidad()`, `getPrecio()`: métodos de acceso.
- `setNombre(nombre: String)`, `setCantidad(cantidad: Int)`, `setPrecio(precio: Double)`: métodos de modificación.
- `calcularPrecioTotal()`: retorna la multiplicación entre cantidad y precio unitario.
- `calcularIVA()`: calcula el 19% del total como impuesto.
- `mostrarInfo()`: imprime los atributos del producto con formato legible y con dos decimales.

La encapsulación se garantiza declarando los atributos como `private` y utilizando getters/setters.

### 4.2 Clase `Inventario`

La clase `Inventario` contiene una lista mutable de productos (`MutableList<Producto>`) y provee métodos para su manipulación:

- `agregarProducto(producto: Producto)`: Verifica si el ID ya existe antes de insertar un producto nuevo.
- `consultarProductos()`: Imprime todos los productos mediante `mostrarInfo()`.
- `modificarProducto(id, nombre, cantidad, precio)`: Busca un producto por su ID y actualiza sus atributos.
- `eliminarProducto(id)`: Elimina el producto si existe en la colección.
- `calcularIVATotal()`: Acumula el IVA de todos los productos utilizando `sumOf()`.

### 4.3 Función `main()`

Esta función es el punto de entrada del programa. Implementa un bucle `do-while` que despliega el siguiente menú al usuario:

```
1. Agregar producto
2. Consultar productos
3. Modificar producto
4. Eliminar producto
5. Calcular IVA total
0. Salir
```

La interacción con el usuario se gestiona por medio de la función auxiliar `leerOpcion()`, que asegura que solo se acepten valores numéricos válidos. Para cada opción, se solicita información necesaria (como ID, nombre, cantidad, precio) y se validan los datos con `toIntOrNull()` y `toDoubleOrNull()`.

En caso de error en la entrada, el sistema notifica y repite la solicitud sin detener la ejecución.

---

## 5. Validaciones Implementadas

- **ID único:** Al agregar un nuevo producto, se verifica si otro con el mismo ID ya existe.
- **Conversión segura:** Se utiliza `toIntOrNull()` y `toDoubleOrNull()` para prevenir fallos por entradas inválidas.
- **Campos obligatorios:** Si un campo requerido es nulo o inválido, se interrumpe el flujo de la operación con un mensaje adecuado.
- **Manejo de casos nulos:** Se previene el acceso a variables nulas usando el operador seguro `?.`.

---

## 6. Resultados Obtenidos

Se realizó exitosamente una simulación funcional completa del sistema, obteniendo los siguientes resultados:

- Se pudo agregar productos de forma dinámica y segura.
- Se visualizaron todos los productos ingresados, mostrando su ID, nombre, cantidad, precio, total e IVA.
- Se logró modificar productos existentes mediante su ID.
- Se eliminó cualquier producto dado su identificador único.
- Se obtuvo el valor total del IVA sumado para todo el inventario.

Las pruebas manuales indicaron que el sistema se comporta correctamente ante entradas válidas y errores comunes del usuario.

---

## 7. Conclusiones

El sistema de gestión de inventario implementado en Kotlin cumple con todos los requisitos funcionales propuestos, y refleja buenas prácticas de desarrollo en consola con orientación a objetos. Su diseño modular permite escalar nuevas funcionalidades sin reestructurar el núcleo lógico. Además, la experiencia del usuario ha sido considerada mediante validaciones y mensajes claros.

---


> *Este sistema fue diseñado e implementado como parte de una práctica de programación orientada a objetos en Kotlin.*

