/*
package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
private lateinit var sqlHelper: dbHelper
private lateinit var rstList: ArrayList<Restraunt>
private lateinit var serList: ArrayList<Restraunt>
private lateinit var  recyclerView: RecyclerView
private var adapter: recyclerAdapter? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getRest()
        add_button.setOnClickListener{
        val intent = Intent(this@MainActivity, AddPage::class.java)
        startActivity(intent)
        }
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
        }

        override fun onQueryTextChange(p0: String?): Boolean {
        serList.clear()
        val searchTxt = p0?.lowercase(Locale.getDefault())
        if (searchTxt != null) {
        if (searchTxt.isNotEmpty()){
        rstList.forEach{
        if (it.name.lowercase(Locale.getDefault()).contains(searchTxt) || it.location.lowercase(Locale.getDefault()).contains(searchTxt)
        || it.description.lowercase(Locale.getDefault()).contains(searchTxt) || it.phone.lowercase(Locale.getDefault()).contains(searchTxt)) {
        serList.add(it)
        }
        }
        recyclerView.adapter?.notifyDataSetChanged()
        } else {
        getRest()
        recyclerView.adapter?.notifyDataSetChanged()
        }
        }
        return false
        }

        })

        return super.onCreateOptionsMenu(menu)
        }

        fun getRest(){
        sqlHelper= dbHelper(this)
        rstList = sqlHelper.getRestraunt()
        serList = ArrayList(rstList)
        adapter?.addRests(serList)
        }
        fun initRecyclerView(){
        recyclerView = rcV
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = recyclerAdapter()
        recyclerView.adapter = adapter
        }
        }*/
