package com.example.aplicaciomovilsoftware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GRecyclerView : AppCompatActivity() {
    var totalLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g_recycler_view)
        val listaEntrenador = arrayListOf<BEntrenador>()
        listaEntrenador
                .add(
                        BEntrenador(
                                "Adrian",
                                "1718137159",
                                DLiga("Kanto", "liga pokemon")
                        )
                )
        listaEntrenador
                .add(
                        BEntrenador(
                                "Vicente",
                                "9827261522",
                                DLiga("Johto", "liga pokemon")
                        )
                )
        val recyclerViewEntrenador = findViewById<RecyclerView>(
                R.id.rv_entrenador
        )
        this.iniciarRecyclerView(
                listaEntrenador,
                this,
                recyclerViewEntrenador
        )
    }

    fun iniciarRecyclerView(
            lista: List<BEntrenador>,
            actividad: GRecyclerView,
            recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptador = FRecyclerViewAdaptadorNombreCedula(
                lista,
                actividad,
                recyclerView
        )

        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptador.notifyDataSetChanged()
    }

    fun anadirLikesTotal() {
        val textoLikes = findViewById<TextView>(R.id.tv_likes_completo)
        totalLikes = totalLikes + 1
        textoLikes.text = totalLikes.toString()
    }
}





