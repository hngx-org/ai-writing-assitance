package com.example.aiwritingassitance.presentation.screens.articlesScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.launch

class ArticleViewModel: ViewModel() {

    var articleTopic by mutableStateOf("")


    var articleResponse by mutableStateOf("")
        private set

    fun getArticleResponse(prompt: String, userId: String = "20"){

        try {
            val essayPrompt = "Generate an article based on the following topic: $articleTopic"

            viewModelScope.launch {
                var generatedResponse = OpenAiCaller.generateChatResponse(essayPrompt, userId)
                // Do something with response
                articleResponse = generatedResponse
                articleTopic = ""
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $articleResponse")
        }catch (e: Exception){
            articleResponse = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }
}