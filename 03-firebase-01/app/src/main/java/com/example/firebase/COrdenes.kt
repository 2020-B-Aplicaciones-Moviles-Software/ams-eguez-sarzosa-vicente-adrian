package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.firebase.dto.FirestoreRestauranteDto
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class COrdenes : AppCompatActivity() {

    val arregloRestaurantes = arrayListOf<FirestoreRestauranteDto>()
    var adaptadorRestaurantes: ArrayAdapter<FirestoreRestauranteDto>? = null
    var restauranteSeleccionado: FirestoreRestauranteDto? = null

    val arregloTiposComida = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_ordenes)

        if (adaptadorRestaurantes == null) {
            adaptadorRestaurantes = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item,
                    arregloRestaurantes
            )
            adaptadorRestaurantes?.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item
            )
            cargarRestaurantes()
        }

        val textViewTipoComida = findViewById<TextView>(R.id.tv_tipos_comida)
        textViewTipoComida.setText("")

        val botonAnadirTipoComida = findViewById<Button>(R.id.btn_anadir_tipo_comida)
        botonAnadirTipoComida
                .setOnClickListener {
                    agregarTipoComida()
                }

        val botonCrearOrden = findViewById<Button>(R.id.btn_crear_orden)

        botonCrearOrden
                .setOnClickListener {
                    crearOrden()
                }
//        buscarOrdenes()

//            crearDatosParaBusquedasPorGrupoColleccon()

        eliminacion()

    }


    fun buscarOrdenes() {
        val db = Firebase.firestore
        val referencia = db.collection("orden")
        // Buscar por un solo campo ==
//        referencia
//                .whereEqualTo("review", 3)
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // Buscar por dos campos ==
//        referencia
//                .whereEqualTo("review", 5)
//                .whereEqualTo("restaurante.nombre", "Las papas de la maria")
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        orden.reference.delete()
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // Buscar por dos o mas elementos campo '==' 'array-contains'
//        referencia
//                .whereEqualTo("restaurante.nombre", "Las papas de la maria")
//                .whereArrayContains("tiposComida", "ecuatoriana")
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // Buscar por dos o mas elementos campo '==' '>='
//        referencia
//                .whereEqualTo("restaurante.nombre", "Fridays")
//                .whereGreaterThanOrEqualTo("review", 3)
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }


        // Buscar por dos o mas elementos campo '==' '>='
//        referencia
//                .whereEqualTo("restaurante.nombre", "Fridays")
//                .whereEqualTo("usuario.email", "b@b.com")
//                .whereGreaterThanOrEqualTo("review", 3) //Agregar la busqueda por email del usuario
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // Buscar por dos o mas elementos campo '==' '>=' ordenar descentente los nombres

        // import com.google.firebase.firestore.Query

//        referencia
//                .whereEqualTo("restaurante.nombre", "fridays") // NO ES NECESARIO ORDENAR CUANDO ES == o array-contains
//                .whereGreaterThanOrEqualTo("review", 3) // SE PUEDE ORDENAR CUANDO NO ES == o array-contains
//                .orderBy("review", Query.Direction.DESCENDING) // enviar la busqueda NO IGUAL primero
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // Buscar por dos o mas elementos campo '==' 'array-contains-any'

//        referencia
//                .whereEqualTo("restaurante.nombre", "Fridays")
//                .whereArrayContainsAny("tiposComida", arrayListOf("española", "japonesa")) // SOLO EN ARREGLOS
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // WHERE IN

//        referencia
//                .whereIn("restaurante.nombre", arrayListOf("Fridays", "Papas de la Maria", "Pepito"))
//                .whereGreaterThanOrEqualTo("review", 1)
//                .get()
//                .addOnSuccessListener {
//                    for (orden in it) {
//                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
//                    }
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-firestore", "Error")
//                }

        // val referencia = db.collection("orden")
        val consulta = referencia
                .limit(2)
        consulta
                .get()
                .addOnSuccessListener {
                    for (orden in it) {
                        Log.i("firebase-consultas", "${orden.id} ${orden.data}")
                    }
                    val ultimoRegistro: QueryDocumentSnapshot = it.last()
                    // siguientes dos ordenes
                    consulta
                            .startAfter(ultimoRegistro)
                            .get().addOnSuccessListener {
                                for (orden in it) {
                                    Log.i("firebase-consultas", "${orden.id} ${orden.data}")
                                }

                            }
                            .addOnFailureListener {
                                Log.i("firebase-firestore", "Error")
                            }
                }
                .addOnFailureListener {
                    Log.i("firebase-firestore", "Error")
                }

        // Crear una actividad
        // List View para mostrar las ordenes
        // Boton para cargar mas registros
    }

    fun crearDatosParaBusquedasPorGrupoColleccon() {

        /// DENTRO DE LAS CIUDADES BJ BUSCAR LOS LANDMARKS QUE TENGAN type = park

        /// DENTRO DE LOS LANDMARKS QUE TENGAN type = park


        val db = Firebase.firestore
        val citiesRef = db.collection("cities")

        val ggbData = mapOf(
                "name" to "Golden Gate Bridge",
                "type" to "bridge"
        )
        citiesRef.document("SF").collection("landmarks").add(ggbData)

        val lohData = mapOf(
                "name" to "Legion of Honor",
                "type" to "museum"
        )
        citiesRef.document("SF").collection("landmarks").add(lohData)

        val gpData = mapOf(
                "name" to "Griffth Park",
                "type" to "park"
        )
        citiesRef.document("LA").collection("landmarks").add(gpData)

        val tgData = mapOf(
                "name" to "The Getty",
                "type" to "museum"
        )
        citiesRef.document("LA").collection("landmarks").add(tgData)

        val lmData = mapOf(
                "name" to "Lincoln Memorial",
                "type" to "memorial"
        )
        citiesRef.document("DC").collection("landmarks").add(lmData)

        val nasaData = mapOf(
                "name" to "National Air and Space Museum",
                "type" to "museum"
        )
        citiesRef.document("DC").collection("landmarks").add(nasaData)

        val upData = mapOf(
                "name" to "Ueno Park",
                "type" to "park"
        )
        citiesRef.document("TOK").collection("landmarks").add(upData)

        val nmData = mapOf(
                "name" to "National Musuem of Nature and Science",
                "type" to "museum"
        )
        citiesRef.document("TOK").collection("landmarks").add(nmData)

        val jpData = mapOf(
                "name" to "Jingshan Park",
                "type" to "park"
        )
        citiesRef.document("BJ").collection("landmarks").add(jpData)

        val baoData = mapOf(
                "name" to "Beijing Ancient Observatory",
                "type" to "musuem"
        )
        citiesRef.document("BJ").collection("landmarks").add(baoData)
    }

    fun cargarRestaurantes() {

        val spinnerRestaurantes = findViewById<Spinner>(R.id.sp_restaurantes)

        spinnerRestaurantes.adapter = adaptadorRestaurantes

        spinnerRestaurantes
                .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.i("firebase-firestore", "No selecciono nada")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                restauranteSeleccionado = arregloRestaurantes[position]
            }

        }


        val db = Firebase.firestore
        val referencia = db.collection("restaurante")
        referencia.get()
                .addOnSuccessListener {
                    for (restaurante in it) {
                        val restauranteCasteado = restaurante.toObject(
                                FirestoreRestauranteDto::class.java
                        )
                        restauranteCasteado.uid = restaurante.id
                        arregloRestaurantes.add(restauranteCasteado)
                    }
                    adaptadorRestaurantes?.notifyDataSetChanged()
                }
                .addOnFailureListener {
                    Log.i("firebase-firestore", "Error ${it}")
                }
    }

    fun agregarTipoComida() {
        val etTipoComida = findViewById<EditText>(R.id.et_tipo_comida)
        val textoTipoComida = etTipoComida.text.toString()

        arregloTiposComida.add(textoTipoComida)

        val textViewTipoComida = findViewById<TextView>(R.id.tv_tipos_comida)

        val textoAnterior = textViewTipoComida.text.toString()

        textViewTipoComida.setText("${textoAnterior}, ${textoTipoComida}")
        etTipoComida.setText("")

    }

    fun crearOrden() {
        if (restauranteSeleccionado != null && FirebaseAuth.getInstance().currentUser != null) {

            val restaurante = restauranteSeleccionado
            val usuario = BAuthUsuario.usuario
            val editTextReview = findViewById<EditText>(R.id.et_review)

            val nuevaOrden = hashMapOf<String, Any?>(
                    "restaurante" to restaurante,
                    "usuario" to usuario,
                    "review" to editTextReview.text.toString().toInt(),
                    "tiposComida" to arregloTiposComida,
                    "fechaCreacion" to Timestamp(Date())
            )

            val db = Firebase.firestore
            val referencia = db.collection("orden")
                    .document()

            referencia
                    .set(nuevaOrden)
                    .addOnSuccessListener {}
                    .addOnFailureListener {}

        }

    }

    fun eliminacion() {
        val db = Firebase.firestore;
        val docRef = db
                .collection("cities")
                .document("BJ")
                .collection("landmarks")
                .document("8bEyoCk7eN4Bh2nEZ9EO")
//
        val eliminarCampo = hashMapOf<String, Any>(
                "name" to FieldValue.delete()
        )
//        docRef
//                .update(eliminarCampo)
//                .addOnSuccessListener {
//                    Log.i("firebase-delete", "${it}")
//                }
//                .addOnFailureListener {
//                    Log.i("firebase-delete", "Error eliminando campo")
//                }
        docRef
                .delete()
                .addOnSuccessListener {
                    Log.i("firebase-delete", "${it}")
                }
                .addOnFailureListener {
                    Log.i("firebase-delete", "Error eliminando campo")
                }

        //

    }

    fun eliminarDocumentosMedianteConsulta(){
        // whereIsEqual() -> delete()
    }

}


















