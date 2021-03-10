package com.example.aplicaciomovilsoftware

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FRecyclerViewAdaptadorNombreCedula(
    private val listaEntrenador: List<BEntrenador>,
    private val contexto: GRecyclerView,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<
        FRecyclerViewAdaptadorNombreCedula.MyViewHolder
        >() {

    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        val nombreTextView: TextView
        val cedulaTextView: TextView
        val likesTextView: TextView
        val acccionButton: Button

        var numeroLikes = 0

        init {
            nombreTextView = view.findViewById(R.id.tv_nombre)
            cedulaTextView = view.findViewById(R.id.tv_cedula)
            acccionButton = view.findViewById(R.id.btn_dar_like)
            likesTextView = view.findViewById(R.id.tv_likes)
            acccionButton.setOnClickListener {
                this.anadirLike()
            }
        }

        fun anadirLike() {
            this.numeroLikes = this.numeroLikes + 1
            likesTextView.text = this.numeroLikes.toString()
            contexto.anadirLikesTotal()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FRecyclerViewAdaptadorNombreCedula.MyViewHolder {
        //  Definimos la interfaz que vamos a usar
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recycler_view_vista, // Recursos recycler_view_vista.xml
                parent,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaEntrenador.size
    }

    // Seteamos el tema visual
    override fun onBindViewHolder(
        holder: FRecyclerViewAdaptadorNombreCedula.MyViewHolder,
        position: Int
    ) {
        val entrenador = listaEntrenador[position]
        holder.nombreTextView.text = entrenador.nombre
        holder.cedulaTextView.text = entrenador.descripcion
        holder.acccionButton.text = "Like ${entrenador.nombre}"
        holder.likesTextView.text = "0"
    }
}