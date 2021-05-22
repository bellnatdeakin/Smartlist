package com.example.smartlist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import androidx.lifecycle.LiveData

class ItemRepository(private val itemDAO: ItemDAO) {
    val getData: LiveData<List<Item>> = itemDAO.getAllItems()

    suspend fun addItem(item: Item){
        itemDAO.insertItem(item)
    }

    fun deleteItem(item: Item) {
        itemDAO.deleteItem(item)
    }

    fun updateItem(item: Item) {
        itemDAO.updateItem(item)
    }
}