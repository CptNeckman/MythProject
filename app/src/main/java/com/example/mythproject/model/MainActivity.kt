package com.example.mythproject.model

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.graphics.Color.red
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mythproject.R
import com.example.mythproject.adapter.MythAdapter
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var navView: NavigationView

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        assetManager("greece")

        navView = findViewById(R.id.nav_view)
        navView.itemIconTintList = null
        navView.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menu_greece -> {
                    assetManager("greece")
                    toolbar.title = "Древняя Греция"
                }
                R.id.menu_rome -> {
                    assetManager("rome")
                    toolbar.title = "Древний Рим"
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }


    private fun assetManager(name: String){
        val assetManager: AssetManager = applicationContext.assets
        val assetList = assetManager.list(name) as Array<String>
        recyclerView.adapter = MythAdapter(this, assetList, name)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}