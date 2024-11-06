package com.example.proj23_25

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")

data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo var title: String,
    @ColumnInfo var author: String
)
