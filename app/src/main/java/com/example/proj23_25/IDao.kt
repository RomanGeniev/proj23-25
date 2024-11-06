package com.example.proj23_25

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IDao {
    @Insert(entity = BookEntity::class)
    fun insertNewBookData(bookEntity: BookEntity)

    @Query("DELETE FROM book WHERE id = :bookId")
    fun deleteBookDataById(bookId: Int)

    @Query("SELECT * FROM book")
    fun getAllBooks(): Flow<List<BookEntity>>
}