package id.ac.ui.cs.mobileprogramming.movielore

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listData: MutableList<String>) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(android.R.layout.simple_list_item_1, p0, false) as TextView
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.listData.size
    }

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.view.text = listData[p1]
    }

    fun addItem(item: String) {
        listData.add(item)
        notifyItemInserted(listData.size - 1)
    }

    class ItemViewHolder(val view: TextView) : RecyclerView.ViewHolder(view)
}