package com.example.smartlist

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.android.synthetic.main.list_item.view.*

@Dao
interface ItemDAO {

    @Query("SELECT * FROM item_table")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Update
    fun updateItem(item: Item)
}