package com.example.aiwritingassitance.loginactivity

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aiwritingassitance.AuthService
import com.example.aiwritingassitance.data.UserData
import com.shegs.hng_auth_library.model.AuthResponse
import com.shegs.hng_auth_library.model.LoginRequest
import com.shegs.hng_auth_library.network.ApiResponse
import com.shegs.hng_auth_library.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewmodel(private val authService: AuthService) : ViewModel() {

    private val _state = mutableStateOf<LoginState>(LoginState())
    val state: State<LoginState> = _state

    var userId: String = ""
    var userEmail: String = ""
    var userName: String = ""
    var userCredit: Int = -1
    var userCookies: String = ""




    suspend fun loginIn(email: String, password: String) : UserData {
        lateinit var userData : UserData
        var result : ApiResponse<AuthResponse>
        val loginRequest = LoginRequest(
            email = email,
            password = password
        )
        viewModelScope.launch {  result = authService.loginRepository.login(loginRequest)
            when(result) {

                is ApiResponse.Error -> {
                    val data = (result as ApiResponse.Error).message
                    //loginResult = "0"
                    userData = UserData(id = userId,
                        email = userEmail,
                        userName = userName,
                        //userCookies = userCookies,
                        userCredit = userCredit)


                    Log.d("ApiResponseResult", "error")
                }
                is ApiResponse.Success -> {
                    val authResponse  = (result as ApiResponse.Success<AuthResponse>).data
                    //loginResult = authResponse.data.id
                    userId = authResponse.data.id
                    userEmail = authResponse.data.email
                    userName = authResponse.data.name
                    userCredit = authResponse.data.credits

                    userData = UserData(id = userId,
                        email = userEmail,
                        userName = userName,
                        //userCookies = userCookies,
                        userCredit = userCredit)


                    /*Log.d("ApiResponseResult", data.status.toString())
                    Log.d("ApiResponseResult", data.message)*/
                    Log.d("ApiResponseResult", authResponse.toString())
                    Log.d("ApiResponseResult", authResponse.data.id)
                }
            }
        }
/*
        when(result) {

            is ApiResponse.Error -> {
                val data = result.message
                //loginResult = "0"
                userData = UserData(id = userId,
                    email = userEmail,
                    userName = userName,
                    //userCookies = userCookies,
                    userCredit = userCredit)


                Log.d("ApiResponseResult", "error")
            }
            is ApiResponse.Success -> {
                val authResponse  = result.data
                //loginResult = authResponse.data.id
                userId = authResponse.data.id
                userEmail = authResponse.data.email
                userName = authResponse.data.name
                userCredit = authResponse.data.credits

                userData = UserData(id = userId,
                    email = userEmail,
                    userName = userName,
                    //userCookies = userCookies,
                    userCredit = userCredit)


                *//*Log.d("ApiResponseResult", data.status.toString())
                Log.d("ApiResponseResult", data.message)*//*
                Log.d("ApiResponseResult", authResponse.toString())
                Log.d("ApiResponseResult", authResponse.data.id)
            }
        }*/
        return userData
    }

    suspend fun profile() : String{

        val result: ApiResponse<AuthResponse> = authService.profileRepository.profile()

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
 /* lateinit var userEmail: MutableLiveData<String>
    lateinit var userName : MutableLiveData<String>
    lateinit var userId : MutableLiveData<String>
    lateinit var userCookies : MutableLiveData<String>
    */
}