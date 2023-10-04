package com.example.aiwritingassitance

import android.content.Context
import com.shegs.hng_auth_library.authlibrary.AuthLibrary
import com.shegs.hng_auth_library.model.AuthResponse
import com.shegs.hng_auth_library.model.SignupRequest
import com.shegs.hng_auth_library.network.ApiResponse

class AuthService(context: Context) {

    val apiService = AuthLibrary.createAuthService()
    private val dataStoreRepository = AuthLibrary.createDataStoreRepository(context = context)

    val signupRepository = AuthLibrary.createSignupRepository(apiService)


    val signupRequest = SignupRequest(
        name = "John Doe",
        email = "johndoe@example.com",
        password = "password123",
        confirm_password = "password123"
    )

    //val result: ApiResponse<AuthResponse> = signupRepository.signup(signupRequest)




}