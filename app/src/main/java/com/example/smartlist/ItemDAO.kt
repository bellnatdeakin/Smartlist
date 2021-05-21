package com.example.smartlist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.android.synthetic.main.list_item.view.*

@Dao
interface ItemDAO {

    @Query("SELECT * FROM item_table")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}