package com.example.aiwritingassitance.presentation.screens.emailScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilibrary.wrapperclass.OpenAiCaller
import kotlinx.coroutines.launch

class EmailViewModel: ViewModel() {

    var emailTopic by mutableStateOf("")

    var emailDestination by mutableStateOf("")


    var EmailResponse by mutableStateOf("")
        private set

    fun getEmailResponse(prompt: String, userId: String = "20"){

        try {
            val emailPrompt = "Generate an email based on the following topic: $emailTopic to the following person $emailDestination"

            viewModelScope.launch {
                var generatedResponse = OpenAiCaller.generateChatResponse(emailPrompt, userId)
                // Do something with response
                EmailResponse = generatedResponse
                emailTopic = ""
                emailDestination = ""
                Log.d("TAG9999", "getResponse: $generatedResponse")
            }
            Log.d("TAG999", "getResponse: $EmailResponse")
        }catch (e: Exception){
            EmailResponse = e.message.toString()
            Log.d("Error99999", "getResponse: ${e.message.toString()}")
        }
    }

}