package com.example.smartlist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val text: String
)