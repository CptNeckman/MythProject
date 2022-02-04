package com.example.mythproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mythproject.R
import com.example.mythproject.model.MainActivity
import com.example.mythproject.model.SecondActivity

class MythAdapter(val context: Context, val name: List<String>, val category: String):
    RecyclerView.Adapter<MythAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mythName: TextView = itemView.findViewById(R.id.mythName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mythName.text = name[position]
        val namePosition = name[position]
        val assets= context.assets
            .open("$category/$namePosition")
            .bufferedReader().use {
                it.readText()
            }

        holder.mythName.setOnClickListener{
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra("namePosition",namePosition)
            intent.putExtra("assets",assets)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return name.size
    }
}