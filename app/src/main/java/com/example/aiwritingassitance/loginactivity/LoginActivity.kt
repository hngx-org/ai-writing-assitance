package com.example.aiwritingassitance.loginactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiwritingassitance.AuthService
import com.example.aiwritingassitance.BottomNavigationActivity
import com.example.aiwritingassitance.data.UserData
import com.example.aiwritingassitance.ui.theme.AIWritingAssitanceTheme
import com.example.aiwritingassitance.ui.theme.Blue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = intent
            val email = intent.getStringExtra("UserEmail")
            val password = intent.getStringExtra("UserPassword")

            AIWritingAssitanceTheme {
                val authService = AuthService(applicationContext)
                var userData : UserData = UserData(id = "", email = "", userName = "", userCredit = -1)

                //val viewModel: LoginViewModel = hiltViewModel()

                var loginEmail by remember {
                    mutableStateOf("")
                }

                var loginPassword by remember {
                    mutableStateOf("")
                }

                var isLoading by remember {
                    mutableStateOf(false) }

                val isDataValidated by remember {
                    derivedStateOf {
                        loginEmail != "" && loginPassword != ""
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top = 50.dp)
                ) {
                    Text(
                        text = "Login",
                        color = Blue,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Login to explore AI-Powered writing assistance",
                        color = Blue,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp),
                        fontWeight = FontWeight.Normal

                    )

                            LoginFields(email = loginEmail, password = loginPassword,
                                onEmailChange = { loginEmail = it },
                                onPasswordChange = { loginPassword = it })

                    if (isLoading) {
                        CircularProgressIndicator()
                    }

                    Button(
                        onClick = {
                            isLoading = true
                            var loginResponse : UserData
                             var cookies : String
                            CoroutineScope(Dispatchers.IO).launch {
                                 loginResponse = authService.loginIn(email = loginEmail, password = loginPassword)
                                    cookies = authService.profile()
                                    Log.d("ApiResponseResult", cookies)
                                 //   Log.d("ApiResponseResult", loginResponse.toString())
                                if(loginResponse.userCredit >= 0) {
                                    Intent(this@LoginActivity, BottomNavigationActivity::class.java).also {
                                        it.putExtra("UserId", loginResponse.id)
                                        it.putExtra("UserEmail", loginResponse.email)
                                        it.putExtra("UserName", loginResponse.userName)
                                        it.putExtra("UserCredit", loginResponse.userCredit)
                                        it.putExtra("UserCookies", cookies)
                                    //    Log.d("ApiResponseResult", loginResponse.toString())
                                        startActivity(it)
                                    }
                                } else {
                                    isLoading = false
                                    //Toast.makeText( this@LoginActivity,"User Detail does not exist", Toast.LENGTH_LONG).show()
                                    Log.d("ApiResponseResult", loginResponse.toString())
                                }
                            }
                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                        enabled = isDataValidated
                    ) {


                        Text(
                            text = "Login",
                            fontSize = 14.sp
                        )
                    }


                }

            }
        }

    }
}

@Composable
fun LoginFields(
    modifier: Modifier = Modifier.fillMaxWidth(),
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    LoginDetailsFields(
        value = email,
        label = "Email Address",
        placeholder = "Enter your email address",
        onValueChaged = onEmailChange
    )

    Spacer(modifier = Modifier.height(15.dp))

    LoginDetailsFields(
        value = password,
        label = "Password",
        placeholder = "Enter your password",
        onValueChaged = onPasswordChange
    )
    Spacer(modifier = Modifier.height(15.dp))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginDetailsFields(
    modifier: Modifier = Modifier.fillMaxWidth(), value: String,
    label: String,
    placeholder: String,
    onValueChaged: (String) -> Unit
) {
    OutlinedTextField(
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue,
            // focusedLabelColor = Grey
        ),
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChaged,

        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        }
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AIWritingAssitanceTheme {
        Greeting("Android")
    }
}