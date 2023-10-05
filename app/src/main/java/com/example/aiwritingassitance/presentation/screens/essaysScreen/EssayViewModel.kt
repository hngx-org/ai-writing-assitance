package com.example.aiwritingassitance.presentation.screens.essaysScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.launch

class EssayViewModel: ViewModel() {

    var essayTopic by mutableStateOf("")


    var EssayResponse by mutableStateOf("")
        private set

    fun getEssayResponse(prompt: String, userId: String = "20"){

        try {
            val essayPrompt = "Generate an essay based on the following topic: $essayTopic. \n" +
                    "Your result should only contain the essay content and no other thing. Your essay should be detailed. If the essay topic doesn't sound like a topic give an error message of \"Please enter a valid essay topic\""

            viewModelScope.launch {
                if (essayTopic.isEmpty()){
                    return@launch
                }

                var generatedResponse = OpenAiCaller.generateChatResponse(essayPrompt, userId)
                // Do something with response
                EssayResponse = generatedResponse
                essayTopic = ""
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $EssayResponse")
        }catch (e: Exception){
            EssayResponse = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }

}