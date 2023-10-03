package com.example.aiwritingassitance.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "chat_table")
data class ChatItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,

    @ColumnInfo
    val response : String,

    @ColumnInfo
    val prompt : String

)