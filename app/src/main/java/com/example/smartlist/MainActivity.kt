package com.example.smartlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    //private lateinit var mUserViewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

}

//
//    override fun onCreate() {
//        val view = inflater.inflate(R.layout.activity_main, container, false)
//
//        val adapter = ListAdapter()
//        val recyclerView = view.recycler_view
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        mUserViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
//        mUserViewModel.readAllData.observe(this, Observer { item -> adapter.setData(item) })
//
//        view.button.setOnClickListener{
//            insertDataDatabase()
//            Toast.makeText(this, "making text", Toast.LENGTH_SHORT).show()
//        }
//
//        return view
//    }
//
//    private fun insertDataDatabase() {
//        val newItem = editItemText.text.toString()
//        mUserViewModel.addItem(Item(0, newItem))
//        Toast.makeText(this, "Added $newItem", Toast.LENGTH_LONG).show()
//    }
//}




//        val database = Room.databaseBuilder(
//            this, ItemDatabase::class.java, "item_database"
//        )
//            .allowMainThreadQueries()
//            .build()
//
//        val allItems = database.itemDao().getAllItems()

//recycler_view.layoutManager = LinearLayoutManager(this)

//recycler_view.adapter = ListItem(allItems, this)



//mUserViewModel.addItem(Item(0, newItem))
//database.itemDao().insertItem(Item(text = newItem, uid = 0))
//recycler_view.adapter!!.notifyDataSetChanged()