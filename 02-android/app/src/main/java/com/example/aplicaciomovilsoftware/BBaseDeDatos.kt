package com.example.aplicaciomovilsoftware

class BBaseDeDatos {
    companion object {
        val arregloEnteros = arrayListOf<Int>()

        fun inicializarArreglo() {
            arregloEnteros.add(1)
            arregloEnteros.add(2)
            arregloEnteros.add(3)
            arregloEnteros.add(4)
            arregloEnteros.add(5)
        }

        fun anadirItemAlArreglo(item: Int) {
            arregloEnteros.add(item)
        }
    }
}