package com.example.mythproject.model

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mythproject.R
import com.example.mythproject.SettingsActivity
import com.example.mythproject.adapter.MythAdapter
import com.google.android.material.navigation.NavigationView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var navView: NavigationView
    private lateinit var search: SearchView
    private lateinit var titleName: String
    private var listData = ArrayList<String>()

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

        search = findViewById(R.id.search)
        search.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterSearch(newText?.toLowerCase(Locale.ROOT))
                    return false
                }
            }
        )
        navView = findViewById(R.id.nav_view)
        navView.itemIconTintList = null
        navView.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menu_greece -> {
                    assetManager("greece")
                    toolbar.title = "?????????????? ????????????"
                    toolbar.setBackgroundResource(R.drawable.background_greece)
                }
                R.id.menu_rome -> {
                    assetManager("rome")
                    toolbar.title = "?????????????? ??????"
                    toolbar.setBackgroundResource(R.drawable.background_rome)
                }
                R.id.menu_china -> {
                    assetManager("china")
                    toolbar.title = "?????????????? ??????????"
                    toolbar.setBackgroundResource(R.drawable.background_china)
                }
                R.id.menu_egypt -> {
                    assetManager("egypt")
                    toolbar.title = "?????????????? ????????????"
                    toolbar.setBackgroundResource(R.drawable.background_egypt)
                }
                R.id.menu_rus -> {
                    assetManager("rus")
                    toolbar.title = "?????????????? ????????"
                    toolbar.setBackgroundResource(R.drawable.background_rus)
                }
                R.id.menu_japan -> {
                    assetManager("japan")
                    toolbar.title = "?????????????? ????????????"
                    toolbar.setBackgroundResource(R.drawable.background_japan)
                }
                R.id.menu_maya -> {
                    assetManager("maya")
                    toolbar.title = "?????????????? ????????"
                    toolbar.setBackgroundResource(R.drawable.background_maya)
                }
                R.id.menu_skandinav -> {
                    assetManager("scandinav")
                    toolbar.title = "??????????????????????"
                    toolbar.setBackgroundResource(R.drawable.background_scandinav)
                }
                R.id.menu_settings -> {
                    val intent = Intent(this,SettingsActivity::class.java)
                    startActivity(intent)
                    toolbar.title = "??????????????????"
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }


    private fun assetManager(name: String){
        val assetManager: AssetManager = applicationContext.assets
        val assetList = assetManager.list(name) as Array<String>
        listData.clear()
        assetList.forEach {
            listData.add(it)
        }
        titleName = name
        recyclerView.adapter = MythAdapter(this, listData, name)
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


    fun filterSearch(query: String?){
        val filtredList = ArrayList<String>()
        if (query != null) {
            listData.filter { it.toLowerCase().contains(query) }.forEach {
                filtredList.add(it)
            }
            recyclerView.adapter = MythAdapter(this, filtredList, titleName)
        }

    }

}