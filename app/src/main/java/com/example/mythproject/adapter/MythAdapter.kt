package com.example.mythproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mythproject.R

class MythAdapter(val name: Array<String>):
    RecyclerView.Adapter<MythAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mythName: TextView = itemView.findViewById(R.id.mythName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MythAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MythAdapter.MyViewHolder, position: Int) {
        holder.mythName.text = name[position]
    }

    override fun getItemCount(): Int {
       return name.size
    }


}