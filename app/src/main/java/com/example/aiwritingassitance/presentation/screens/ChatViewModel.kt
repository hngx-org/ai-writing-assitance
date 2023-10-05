package com.example.aiwritingassitance.presentation.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {



//    ESSAY
    var essayTopic by mutableStateOf("")














    var response by mutableStateOf("")
        private set

    fun getResponse(prompt: String, userId: String = ""){

        try {
            val testPrompt = "Generate an email based on the following topic: $prompt"

            viewModelScope.launch {
                var generatedResponse = OpenAiCaller.generateChatResponse(testPrompt, "20")
                // Do something with response
                response = generatedResponse
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $response")
        }catch (e: Exception){
            response = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }


//    val response = OpenAiCaller.generateChatResponse("", "")
}