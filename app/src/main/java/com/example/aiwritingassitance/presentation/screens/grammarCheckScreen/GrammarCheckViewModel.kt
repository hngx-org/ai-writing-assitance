package com.example.aiwritingassitance.presentation.screens.grammarCheckScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.launch

class GrammarCheckViewModel: ViewModel() {

    var essayTopic by mutableStateOf("")


    var EssayResponse by mutableStateOf("")
        private set

    fun getEssayResponse(prompt: String, userId: String = "20"){

        try {
            val essayPrompt = "Generate an essay based on the following topic: $essayTopic"

            viewModelScope.launch {
                var generatedResponse = OpenAiCaller.generateChatResponse(essayPrompt, userId)
                // Do something with response
                EssayResponse = generatedResponse
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $EssayResponse")
        }catch (e: Exception){
            EssayResponse = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }


}