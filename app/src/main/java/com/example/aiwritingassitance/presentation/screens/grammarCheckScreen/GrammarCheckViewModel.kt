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

    var inputText by mutableStateOf("")

    var refinedText by mutableStateOf("")
        private set

    fun refactorText(prompt: String, userId: String = "20"){

        try {
            val refinePrompt = "Refine the following text: $inputText"

            viewModelScope.launch {
                var generatedResponse = OpenAiCaller.generateChatResponse(refinePrompt, userId)
                // Do something with response
                refinedText = generatedResponse
                inputText = ""
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $refinedText")
        }catch (e: Exception){
            refinedText = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }


}