package com.example.smartlist

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "item_table")
data class Item (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val text: String,
    var checked: Boolean
): Parcelable