package com.example.aiwritingassitance.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChatDao {

    @Query("SELECT * FROM chat_table")
    fun getAll(): LiveData<MutableList<ChatItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chatItem: ChatItem)

    @Delete
    fun delete(chatItem: ChatItem)

    @Query("DELETE FROM chat_table")
    fun deleteAll()

}