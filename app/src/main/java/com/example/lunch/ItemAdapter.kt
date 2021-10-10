package com.example.lunch

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_elem.view.*

class ItemAdapter (val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    fun AddItem(item: Item) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun DeleteItem(currentItem: Item) {
        items.remove(currentItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_elem,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.apply {
            tv_list_elem.text = currentItem.title
            btn_minus.setOnClickListener {
                DeleteItem(currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}