import java.util.*

fun main() {
    println("Hola mundo");
    // Ejemplo JAVA Int edad = 31
    var edadProfesor = 31
    // var edadProfesor: Int = 31
    var sueldoProfesor = 31.23
    // var sueldoProfesor: Double = 31.23;
    // Duck Typing

    // Variables MUTABLES (Reasignando valores)
    var edadCachorro: Int
    edadCachorro = 1
    edadCachorro = 5
    edadCachorro = 6
    // Variables INMUTABLES (NO PODEMOS REASIGNAR EL VALOR)
    val numeroCedula = 1718137159
    // numeroCedula = 123123Varia

    // Tipos de variables

    val nombrProfesor: String = "Adrian Eguez"
    val sueldo: Double = 12.2
    val estadoCivil: Char = 'S'
    val fechaNacimiento = Date()

    // Condicionales

    if (sueldo == 12.20) {
        // Verdadero
    } else {

    }

    when (sueldo) {
        12.2 -> { //  Inicio bloque codigo
            println(" Sueldo Normal ")
        }//  Fin bloque codigo
        -12.2 -> println(" Sueldo negativo ")
        else -> println("Sueldo no reconocido")
    }

    val sueldoMayorAlEstablecido = if (sueldo == 12.2) false else true
    // val sueldoMayorAlEstablecido = if (sueldo == 12.2) 2 else 20
    // condicion ? bloque-true : bloque-false
    // imprimirNombre("Adrian")
    imprimirNombre("Adrian")
    // calcularSueldo(1000.00)
    calcularSueldo(1000.00)
    // calcularSueldo(1000.00, 14.00)
    calcularSueldo(1000.00, 14.00)
    // calcularSueldo(1000.00, 14.00, 3)
    calcularSueldo(1000.00, 14.00, 3)

    // Quiero solo enviar sueldo y calculoEspecial, y que se mantenga la tasa por defecto

    calcularSueldo(
            1000.00,
            // 12.00,
            calculoEspecial = 3 // Named Parameters (parametros nombrados)
    )
    calcularSueldo(
            calculoEspecial = 3, // Named Parameters (parametros nombrados)
            tasa = 14.00,
            sueldo = 1000.00
    )

    // Arreglos
    // ctrl + alt + l = INDENTACIÓN

    // Arreglo ESTATICO (no se puede modificar los elementos del arreglo)
    var arregloInmutable: Array<Int> = arrayOf(1, 2, 3)
    arregloInmutable = arrayOf(2, 3, 4, 5, 6)
    // arregloInmutable.add(12) NO ES POSIBLE

    // Arreglo DINAMICO (se puede modificar los elementos del arreglo)
    val arregloMutable: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloMutable)
    arregloMutable.add(11)
    arregloMutable.add(12)
    println(arregloMutable)

    // OPERADORES - Sirven para los arreglos Estaticos y Dinamicos

    // arregloMutable.forEach{  }
    // arregloInmutable.forEach {  }

    // Void = Unit (El unit es cuando no se devuelve nada en Kotlin)
    // Operador FOREACH
    val respuestaForEach: Unit = arregloMutable.forEach { valorIteracion -> // Sin definir el tipo de dato (DUCK TYPING)
        // valorIteracion: Int -> // Sin definir el tipo de dato (DUCK TYPING)
        println("Valor: ${valorIteracion}")
    }
    // Operador FOREACHINDEXED
    val respuestaForEachIndexed: Unit = arregloMutable.forEachIndexed { indice, valorIteracion ->
        // valorIteracion: Int -> // Sin definir el tipo de dato (DUCK TYPING)
        println("Valor: ${valorIteracion} Indice: ${indice}")
    }

    // MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados
    val respuestaMap: List<Int> = arregloMutable.map { valorActualIteracion ->
        // Linea 1
        // Linea 2
        return@map valorActualIteracion * 10
    }
    println(respuestaMap)
    arregloMutable.map { valorActualIteracion -> valorActualIteracion + 15 } // Sintaxis corta

    // Filter -> FILTRAR EL ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloMutable.filter { valorActualIteracion ->
        val mayoresACinco: Boolean = valorActualIteracion > 5
        return@filter mayoresACinco // Devolver un booleano
    }
    println(respuestaFilter)
    arregloMutable.filter { i -> i > 5 }
    arregloMutable.filter { it > 5 }

    // Any All -> Revisar una condicion dentro del arreglo
    // OR - AND
    // OR = Any
    // OR (FALSO - TODOS TIENEN QUE SER FALSO)
    // OR (TRUE - UNO ES TRUE YA ES TRUE)
    // AND (FALSO - SI UNO ES FALSO YA ES FALSO)
    // AND (TRUE - TODOS SON TRUE ES TRUE)
    // All = AND

    val respuestaAny: Boolean = arregloMutable
            .any { valorActualIteracion ->
                return@any valorActualIteracion > 5 // TRUE o FALSE
            }
    println(arregloMutable)
    println(respuestaAny)

    val respuestaAll: Boolean = arregloMutable
            .all { valorActualIteracion ->
                return@all valorActualIteracion > 0 // TRUE o FALSE
            }
    println(arregloMutable)
    println(respuestaAll)

    // REDUCE
    // 1) Devuelve el acumulado
    // 2) En que valor empieza
    // [1,2,3,4,5]
    //    0 = 0 + (1)
    //    1 = 1 + (2)
    //    3 = 3 + (3)
    //    6 = 6 + (5)
    // [b,c,d,e]
    //    a = a + b
    //    ab = ab + c
    //    abc = abc + d
    val respuestaReduce: Int = arregloMutable // VALOR DEL ACUMULADO POR DEFECTO ES 0
            .reduce { acumulado, valorActualIteracion ->
                return@reduce acumulado + valorActualIteracion
            }
    println(arregloMutable)
    println(respuestaReduce)
    val respuestaReduceFold = arregloMutable // Acumulado empieza donde yo le diga
            .fold(
                    100,
                    { acumulado, valorActualIteracion ->
                        return@fold acumulado - valorActualIteracion
                    }
            )
    println(arregloMutable)
    println(respuestaReduceFold)
    // arregloMutable.fold (empieza desde el principio
    // arregloMutable.foldRight (empieza desde el final
    // arregloMutable.reduce (empieza desde el final
    // arregloMutable.reduceRight (empieza desde el final

    // OPERADORES
    // forEach -> Unit (void)
    // map -> Arreglo
    // filter -> Arreglo
    // all -> Booleano
    // any -> Booleano
    // reduce -> Valor
    // fold -> Valor

    val vidaActual: Double = arregloMutable
            .map { it * 2.3 } // arreglo
            .filter { it > 20 } // arreglo
            .fold(100.00, { acc, i -> acc - i }) //  valor
            .also { println(it) } // mostrar el valor
    println("Valor vida actual ${vidaActual}")

    val ejemploUno = Suma(1, 2, 3)
    val ejemploDos = Suma(1, null, 3)
    val ejemploTres = Suma(null, null, null)
    println(ejemploUno.sumar())
    println(Suma.historialSumas)
    println(ejemploDos.sumar())
    println(Suma.historialSumas)
    println(ejemploTres.sumar())
    println(Suma.historialSumas)


} // (main cerrado)


fun imprimirNombre(nombre: String) {
    println("Nombre: ${nombre}")
}

fun calcularSueldo(
        sueldo: Double, // Requerido
        tasa: Double = 12.00, // Opcional con valor por defecto 12.00,
        calculoEspecial: Int? = null // Calculo especial es un entero
        // con valor inicial de "null"
): Double {
    // String -> String? (puede ser nulo)
    // Int -> Int? (puede ser nulo)
    // Date -> Date? (puede ser nulo)
    if (calculoEspecial == null) {
        return sueldo * (100.00 / tasa)
    } else {
        return sueldo * (100.00 / tasa) * calculoEspecial
    }
}

abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor( // Constructor primario
            uno: Int,
            dos: Int) { // Bloque de codigo del constructor primario
        numeroUno = uno
        numeroDos = dos
        println(numeroUno)
        println(numeroDos)
    }
}

abstract class Numeros( // Constructor primario
        protected var numeroUno: Int,
        protected var numeroDos: Int) {
    init {
        println(numeroUno)
        println(numeroDos)
    }
}
// val numerosNumero = Numeros(1,2)
// numerosNumero.numeroUno
// numerosNumero.numeroDos

class Suma(
        uno: Int,
        dos: Int,
        protected var tres: Int
        // cuatro: Int
) : Numeros(uno, dos) {
    init {
        // this.numeroUno
        // this.numeroDos
        // this.sumar()
        println("Costructor primario init")
    }

    constructor(
            uno: Int, // Parametro
            dos: Int?, // Parametro
            tres: Int // Parametro
    ) : this( //  Llamada al constructor primario
            uno,
            if (dos == null) 0 else dos,
            tres
    ) {

    }

    constructor(
            uno: Int?, // Parametro
            dos: Int?, // Parametro
            tres: Int? // Parametro
    ) : this( //  Llamada al constructor primario
            if (uno == null) 0 else uno,
            if (dos == null) 0 else dos,
            if (tres == null) 0 else tres
    ) {

    }

    public fun sumar(): Int {
        // this.uno NO EXISTEN SOLO SON PARAMETROS
        // this.dos NO EXISTEN SOLO SON PARAMETROS
        this.tres
        val total: Int = this.numeroUno + this.numeroDos
        Suma.agregarHistorial(total)
        return total
    }

    companion object { // SINGLETON // METODOS Y ATRIBUTOS
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(nuevaSuma: Int) {
            this.historialSumas.add(nuevaSuma)
        }
    }

}

class BaseDeDatos() {
    companion object {
        val datos = arrayListOf<Int>()
    }
}









