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
//            val emailPrompt = "Generate an email based on the following topic: $emailTopic to the following person $emailDestination"

            val emailPrompt = "\n" +
                    "Generate an email based on the following topic: $emailTopic, and to the following person: $emailDestination. \n" +
                    "Your result should only contain the email content and no other thing. Your email should be detailed. If the email topic doesn't sound like a topic give an error message of \"Please enter a valid email topic\". If the person stated doesn't sound like a valid noun or pronoun, give an error message of \"Please enter a valid person\""


            viewModelScope.launch {
                if (emailTopic.isEmpty() || emailDestination.isEmpty()){
                    return@launch
                }

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