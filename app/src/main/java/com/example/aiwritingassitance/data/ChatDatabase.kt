package com.example.aiwritingassitance.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ChatItem::class],
          version = 1)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao

    companion object {
        @Volatile
        var databaseInstance: ChatDatabase? = null

        fun getDatabase(context: Context): ChatDatabase {

            val tempInstance = databaseInstance
            if (tempInstance != null) {
                return tempInstance
            }
            else {
                val instance = Room.databaseBuilder(
                    context,
                    ChatDatabase::class.java,
                    "todo_database"
                ).build()
                databaseInstance = instance
                return instance
            }
        }
    }


}