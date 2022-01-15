package com.example.mythproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mythproject.adapter.MythAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = arrayOf("Зевс","Афродита","Аполлон","Геракл","Аид","Персефона","Посейдон","Кура Гриль")// Вместо этого списка будет информация с SQLite

        recyclerView.adapter = MythAdapter(list)
    }

}