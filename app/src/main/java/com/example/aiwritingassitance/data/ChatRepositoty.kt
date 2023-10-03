package com.example.aiwritingassitance.data

class ChatRepositoty(private val db : ChatDatabase) {
    suspend fun insert(chatItem: ChatItem) = db.chatDao().insert(chatItem = chatItem)

    fun getAllChatItem() = db.chatDao().getAll()

    suspend fun deleteAll() = db.chatDao().deleteAll()

    suspend fun delete(chatItem: ChatItem) = db.chatDao().delete(chatItem)
}