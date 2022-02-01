package com.example.mythproject.model

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.os.Bundle
import android.view.MenuItem
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
                    toolbar.setBackgroundResource(R.drawable.background_greece)
                }
                R.id.menu_rome -> {
                    assetManager("rome")
                    toolbar.title = "Древний Рим"
                    toolbar.setBackgroundResource(R.drawable.background_rome)
                }
                R.id.menu_china -> {
                    assetManager("china")
                    toolbar.title = "Древний Китай"
                    toolbar.setBackgroundResource(R.drawable.background_china)
                }
                R.id.menu_egypt -> {
                    assetManager("egypt")
                    toolbar.title = "Древний Египет"
                    toolbar.setBackgroundResource(R.drawable.background_egypt)
                }
                R.id.menu_rus -> {
                    assetManager("rus")
                    toolbar.title = "Древняя Русь"
                    toolbar.setBackgroundResource(R.drawable.background_rus)
                }
                R.id.menu_japan -> {
                    assetManager("japan")
                    toolbar.title = "Древняя Япония"
                    toolbar.setBackgroundResource(R.drawable.background_japan)
                }
                R.id.menu_maya -> {
                    assetManager("maya")
                    toolbar.title = "Индейцы Майя"
                    toolbar.setBackgroundResource(R.drawable.background_maya)
                }
                R.id.menu_skandinav -> {
                    assetManager("scandinav")
                    toolbar.title = "Скандинавия"
                    toolbar.setBackgroundResource(R.drawable.background_scandinav)
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