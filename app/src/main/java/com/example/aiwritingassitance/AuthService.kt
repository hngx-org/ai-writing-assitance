package com.example.aiwritingassitance

import android.content.Context
import android.util.Log
import com.shegs.hng_auth_library.authlibrary.AuthLibrary
import com.shegs.hng_auth_library.model.AuthResponse
import com.shegs.hng_auth_library.model.LoginRequest
import com.shegs.hng_auth_library.model.SignupRequest
import com.shegs.hng_auth_library.network.ApiResponse

class AuthService(context: Context) {
    var signUpResult : Boolean = false
    var loginResult : Boolean = false

    val apiService = AuthLibrary.createAuthService()
    private val dataStoreRepository = AuthLibrary.createDataStoreRepository(context = context)

    val signupRepository = AuthLibrary.createSignupRepository(apiService = apiService)

    val loginRepository = AuthLibrary.createLoginRepository(apiService = apiService, dataStoreRepository = dataStoreRepository)

    

    suspend fun signUp(name : String, email : String, password : String) : Boolean {
        var result : ApiResponse<AuthResponse>
        val signupRequest = SignupRequest(
            name = name,
            email = email,
            password = password,
            confirm_password = password
        )
        result = signupRepository.signup(signupRequest)
        when(result) {

            is ApiResponse.Error -> {
                signUpResult = false
                Log.d("ApiResponseResult", "error")
            }
            is ApiResponse.Success -> {
                signUpResult = true
                Log.d("ApiResponseResult", "success")
            }
        }
        return signUpResult
    }

    suspend fun loginIn(email: String, password: String) : Boolean {
        val result : ApiResponse<AuthResponse>
        val loginRequest = LoginRequest(
            email = email,
            password = password
        )

        result = loginRepository.login(loginRequest)
        when(result) {

            is ApiResponse.Error -> {
                val data = result.message
                loginResult = false
                Log.d("ApiResponseResult", "error")
            }
            is ApiResponse.Success -> {
                val data = result.data
                loginResult = true
                Log.d("ApiResponseResult", data.message)
            }
        }
        return loginResult
    }

}