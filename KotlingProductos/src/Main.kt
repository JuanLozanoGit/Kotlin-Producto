class Producto(
    private var id: Int,
    private var nombre: String,
    private var cantidad: Int,
    private var precio: Double
) {
    fun getId(): Int = id
    fun getNombre(): String = nombre
    fun getCantidad(): Int = cantidad
    fun getPrecio(): Double = precio

    fun setNombre(nombre: String) { this.nombre = nombre }
    fun setCantidad(cantidad: Int) { this.cantidad = cantidad }
    fun setPrecio(precio: Double) { this.precio = precio }

    fun calcularPrecioTotal(): Double = cantidad * precio
    fun calcularIVA(): Double = calcularPrecioTotal() * 0.19

    fun mostrarInfo() {
        println(
            "ID: $id | Nombre: $nombre | Cantidad: $cantidad | Precio: $${"%.2f".format(precio)} | " +
                    "Total: $${"%.2f".format(calcularPrecioTotal())} | IVA: $${"%.2f".format(calcularIVA())}"
        )
    }
}

class Inventario {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        if (productos.any { it.getId() == producto.getId() }) {
            println("Error: ya existe un producto con ese ID.")
        } else {
            productos.add(producto)
            println("Producto agregado con éxito.")
        }
    }

    fun consultarProductos() {
        if (productos.isEmpty()) {
            println("No hay productos en el inventario.")
        } else {
            productos.forEach { it.mostrarInfo() }
        }
    }

    fun modificarProducto(id: Int, nombre: String, cantidad: Int, precio: Double) {
        val producto = productos.find { it.getId() == id }
        if (producto != null) {
            producto.setNombre(nombre)
            producto.setCantidad(cantidad)
            producto.setPrecio(precio)
            println("Producto modificado con éxito.")
        } else {
            println("Producto no encontrado.")
        }
    }

    fun eliminarProducto(id: Int) {
        val producto = productos.find { it.getId() == id }
        if (producto != null) {
            productos.remove(producto)
            println("Producto eliminado con éxito.")
        } else {
            println("Producto no encontrado.")
        }
    }

    fun calcularIVATotal(): Double = productos.sumOf { it.calcularIVA() }
}

fun leerOpcion(): Int {
    while (true) {
        print("Seleccione una opción: ")
        val input = readLine()
        val opcion = input?.toIntOrNull()
        if (opcion != null) return opcion
        println("Entrada inválida. Por favor, ingrese un número del menú.")
    }
}

fun main() {
    val inventario = Inventario()
    var opcion: Int

    do {
        println("\n--- Sistema de Gestión de Inventario ---")
        println("1. Agregar producto")
        println("2. Consultar productos")
        println("3. Modificar producto")
        println("4. Eliminar producto")
        println("5. Calcular IVA total")
        println("0. Salir")

        opcion = leerOpcion()

        when (opcion) {
            1 -> {
                print("Ingrese ID del producto: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("ID inválido.")
                    continue
                }

                print("Ingrese nombre del producto: ")
                val nombre = readLine() ?: ""

                print("Ingrese cantidad: ")
                val cantidad = readLine()?.toIntOrNull()
                if (cantidad == null) {
                    println("Cantidad inválida.")
                    continue
                }

                print("Ingrese precio: ")
                val precio = readLine()?.toDoubleOrNull()
                if (precio == null) {
                    println("Precio inválido.")
                    continue
                }

                val producto = Producto(id, nombre, cantidad, precio)
                inventario.agregarProducto(producto)
            }

            2 -> inventario.consultarProductos()

            3 -> {
                print("Ingrese ID del producto a modificar: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("ID inválido.")
                    continue
                }

                print("Ingrese nuevo nombre del producto: ")
                val nombre = readLine() ?: ""

                print("Ingrese nueva cantidad: ")
                val cantidad = readLine()?.toIntOrNull()
                if (cantidad == null) {
                    println("Cantidad inválida.")
                    continue
                }

                print("Ingrese nuevo precio: ")
                val precio = readLine()?.toDoubleOrNull()
                if (precio == null) {
                    println("Precio inválido.")
                    continue
                }

                inventario.modificarProducto(id, nombre, cantidad, precio)
            }

            4 -> {
                print("Ingrese ID del producto a eliminar: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("ID inválido.")
                    continue
                }

                inventario.eliminarProducto(id)
            }

            5 -> {
                val ivaTotal = inventario.calcularIVATotal()
                println("IVA total del inventario: $${"%.2f".format(ivaTotal)}")
            }

            0 -> println("Saliendo del sistema...")

            else -> println("Opción no válida.")
        }
    } while (opcion != 0)
}
