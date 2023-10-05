package com.example.aiwritingassitance

import android.content.Context
import android.util.Log
import com.example.aiwritingassitance.data.UserData
import com.shegs.hng_auth_library.authlibrary.AuthLibrary
import com.shegs.hng_auth_library.model.AuthResponse
import com.shegs.hng_auth_library.model.LoginRequest
import com.shegs.hng_auth_library.model.SignupRequest
import com.shegs.hng_auth_library.network.ApiResponse
import com.shegs.hng_auth_library.network.RetrofitClient
import java.util.Date

class AuthService(context: Context) {
    var signUpResult : Boolean = false
    var loginResult : String = "0"
    var loginResponseId: String = ""
    var loginResponseEmail: String = ""
    var loginResponseUsername: String = ""
    var loginResponseCredit: Int = -1

    val apiService = AuthLibrary.createAuthService()
    private val dataStoreRepository = AuthLibrary.createDataStoreRepository(context = context)

    val signupRepository = AuthLibrary.createSignupRepository(apiService = apiService)

    val loginRepository = AuthLibrary.createLoginRepository(apiService = apiService, dataStoreRepository = dataStoreRepository)

    val logoutRepository = AuthLibrary.createLogoutRepository(apiService)

    val profileRepository = AuthLibrary.createProfileRepository(apiService)




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

    suspend fun loginIn(email: String, password: String) : UserData {
        lateinit var userData : UserData
        val result : ApiResponse<AuthResponse>
        val loginRequest = LoginRequest(
            email = email,
            password = password
        )

        result = loginRepository.login(loginRequest)
        when(result) {

            is ApiResponse.Error -> {
                val data = result.message
                loginResult = "0"
                userData = UserData(id = loginResponseId,
                    email = loginResponseEmail,
                    userName = loginResponseUsername,
                    userCredit = loginResponseCredit)


                Log.d("ApiResponseResult", "error")
            }
            is ApiResponse.Success -> {
                val authResponse  = result.data
                loginResult = authResponse.data.id
                loginResponseId = authResponse.data.id
                loginResponseEmail = authResponse.data.email
                loginResponseUsername = authResponse.data.name
                loginResponseCredit = authResponse.data.credits

                userData = UserData(id = loginResponseId,
                    email = loginResponseEmail,
                    userName = loginResponseUsername,
                    userCredit = loginResponseCredit)


                /*Log.d("ApiResponseResult", data.status.toString())
                Log.d("ApiResponseResult", data.message)*/
                Log.d("ApiResponseResult", authResponse.toString())
                Log.d("ApiResponseResult", authResponse.data.id)
            }
        }
        return userData
    }

    suspend fun loginOut(){
        val result  = logoutRepository.logout()

        when(result) {

            is ApiResponse.Error -> {
                val message = result.message
                Log.d("ApiResponseResult", message)
            }

            is ApiResponse.Success -> {
                val authResponse = result.data
                Log.d("ApiResponseResult", authResponse.toString())
            }
        }
    }

    suspend fun profile() : String{

        val result: ApiResponse<AuthResponse> = profileRepository.profile()

        //var cookies: String = "";
        var cookies = RetrofitClient.getCookiesForUrl().toString()

        when(result) {
            is ApiResponse.Error -> {
                val message = result.message
              //  Log.d("ApiResponseResult", message)
            }

            is ApiResponse.Success -> {
                val authResponse = result.data
              //  Log.d("ApiResponseResult", authResponse.toString())
              //  Log.d("ApiResponseResult", cookies)
              //  Log.d("ApiResponseResult", cookies)
            }
        }
        return cookies
    }
}


/*
data class UserData(
    val created_at: Date,
    val credit: Int,
    val email: String,
    val id: String,
    val name: String,
    val updated_at: Date
)


data class AuthResponse(
    val data: UserData,
    val message: String,
    val status: String?
)
*/
