package com.example.listaparticipantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listaparticipantes.model.Participante
import com.example.listaparticipantes.utils.Constants.ANERODRIGUES
import com.example.listaparticipantes.utils.Constants.FELIPERODRIGUES
import com.example.listaparticipantes.utils.Constants.FERNANDARODRIGUES
import com.example.listaparticipantes.utils.Constants.FERNANDORODRIGUES
import com.example.listaparticipantes.utils.Constants.TIAGORODRIGUES
import kotlin.properties.Delegates

class ParticipantesAdapter : RecyclerView.Adapter<ParticipantesViewHolder>(), Filterable {

    var items: List<Participante> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var participanteItems: List<Participante> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var filterItems = ArrayList<Participante>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantesViewHolder {
        return ParticipantesViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_part, parent, false))
    }

    override fun onBindViewHolder(holder: ParticipantesViewHolder, position: Int) {
        val atual = items[position]
        holder.bind(item = atual)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterItems = if (charSearch.isEmpty()) {
                    participanteItems as ArrayList<Participante>
                } else {
                    val resultList = ArrayList<Participante>()
                    for (row in participanteItems) {
                        if (row.name.
                                toLowerCase()
                                        .contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResultsList = FilterResults()
                filterResultsList.values = filterItems
                return filterResultsList
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                try {
                    items = results?.values as List<Participante>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                    items = participanteItems

                }
            }

        }
    }

}

class ParticipantesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Participante) {
        val nameParticipante = itemView.findViewById<TextView>(R.id.tv_name_part)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        with(itemView) {
            nameParticipante.text = item.name

            if (item.name == ANERODRIGUES){
                imageView.background =
                        context.resources.getDrawable(R.drawable.ane)
            }
            if (item.name == FELIPERODRIGUES){
                imageView.background =
                        context.resources.getDrawable(R.drawable.felipe)
            }
            if (item.name == FERNANDARODRIGUES){
                imageView.background =
                        context.resources.getDrawable(R.drawable.fernanda)
            }
            if (item.name == FERNANDORODRIGUES){
                imageView.background =
                        context.resources.getDrawable(R.drawable.fernando)
            }
            if (item.name == TIAGORODRIGUES){
                imageView.background =
                        context.resources.getDrawable(R.drawable.tiago)
            }
        }
    }

}
