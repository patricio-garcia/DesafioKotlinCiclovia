package cl.serlitoral.desafiokotlinciclovia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.desafiokotlinciclovia.databinding.ItemListBinding
import cl.serlitoral.desafiokotlinciclovia.model.Ciclovia
import cl.serlitoral.desafiokotlinciclovia.util.SetupCiclovias

class CicloviaAdapter: RecyclerView.Adapter<CicloviaAdapter.CicloviaAdapterVH>() {

    val cicloviaSetUp = SetupCiclovias()
    var lista = cicloviaSetUp.getCiclovias()

    class CicloviaAdapterVH(var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cicloviaList: Ciclovia) {
            binding.comunaText.text = cicloviaList.comuna
            binding.cicloviaText.text = cicloviaList.nombre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CicloviaAdapterVH {
        val bindig = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CicloviaAdapterVH(bindig)
    }

    override fun onBindViewHolder(holder: CicloviaAdapterVH, position: Int) {
        val cicloviaList = lista.get(position)
        holder.bind(cicloviaList)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateFilter(comuna: String) {
        lista.clear()
        lista = cicloviaSetUp.getComunaFilter(comuna)
        notifyDataSetChanged()
    }

    fun updateWithoutFilter() {
        lista.clear()
        lista = cicloviaSetUp.getCiclovias()
        notifyDataSetChanged()
    }

}

