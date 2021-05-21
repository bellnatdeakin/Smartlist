package com.example.smartlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application){
    val readAllData: LiveData<List<Item>>
    private val repository: ItemRepository

    init {
        val itemDAO = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDAO)
        readAllData = repository.getData
    }

    fun addItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(item)
        }
    }


}