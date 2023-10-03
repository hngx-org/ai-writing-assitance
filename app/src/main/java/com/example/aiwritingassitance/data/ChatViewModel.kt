package com.example.aiwritingassitance.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel (
    private val chatRepository: ChatRepositoty
): ViewModel() {

    var list = chatRepository.getAllChatItem()

    fun insert(chatItem: ChatItem) = viewModelScope.launch(context = Dispatchers.IO) { chatRepository.insert(chatItem) }

    fun deleteAll() = viewModelScope.launch(context = Dispatchers.IO) { chatRepository.deleteAll() }

    fun delete(chatItem: ChatItem) = viewModelScope.launch(context = Dispatchers.IO) { chatRepository.delete(chatItem = chatItem) }
}