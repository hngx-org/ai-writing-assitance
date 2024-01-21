package com.example.aiwritingassitance

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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiwritingassitance.loginactivity.LoginActivity
import com.example.aiwritingassitance.ui.theme.AIWritingAssitanceTheme
import com.example.aiwritingassitance.ui.theme.Blue
import com.example.aiwritingassitance.ui.theme.Grey
import com.example.aiwritingassitance.ui.theme.Neutral1
import com.example.aiwritingassitance.ui.theme.Neutral2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            AIWritingAssitanceTheme {
                val authService = AuthService(MyApp.appContext)

                /*val intent = intent
                val isToken = intent.getBooleanExtra("EntryMessage", true)*/


                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var name by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }
                var isLoading by remember { mutableStateOf(false) }

                val isDataValidated by remember {
                    derivedStateOf {
                         name != "" && email != "" && password != "" && confirmPassword != ""  && password == confirmPassword
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Create Account",
                        color = Neutral2,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Sign up to explore AI-Powered Writing Assistance",
                        color = Neutral2,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp),
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    CreateAccountFields(
                        modifier = Modifier.fillMaxWidth(),
                        name = name,
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword,
                        onNameChanged = {
                            name = it
                                        },
                        onEmailChanged = {
                            email = it
                                         },
                        onPasswordChanged = {
                            password = it
                                            },
                        onConfirmPasswordChanged = {
                            confirmPassword = it
                        }
                    )
                    if (isLoading) {
                        CircularProgressIndicator()
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {

                            isLoading = true
                            CoroutineScope(Dispatchers.IO).launch {
                                val signUpResult = authService.signUp(name = name, email = email, password = password)
                                Log.d("ApiResponseResult", "$name $email $password")

                                if(signUpResult){
                                    Intent(this@SignUpActivity, LoginActivity::class.java).also {
                                        it.putExtra("UserEmail", email)
                                        it.putExtra("UserPassword", password)
                                        startActivity(it)
                                    }
                                } else {
                                    isLoading = false
                                }


                                Log.d("Debuggg", "Gooooooo")
                            }

                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth(),
                        enabled = isDataValidated
                    ) {
                        Text(text = "Continue", color = Neutral1)
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            Intent(this@SignUpActivity, LoginActivity::class.java).also {
                               // it.putExtra("EntryMessage", isToken)
                                startActivity(it)
                            }
                        },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Text(text = "Already have an account", color = Neutral1)
                    }

                }
            }
        }
    }
}


@Composable
fun CreateAccountFields(
    modifier: Modifier = Modifier.fillMaxWidth(),
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    onEmailChanged: (String) -> Unit,
    onNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onConfirmPasswordChanged: (String) -> Unit,
) {

    var showPassword by remember {
        mutableStateOf(false)
    }

    DetailsFields(
        value = email,
        label = "Email",
        placeholder = "Enter your email address",
        onValueChaged = onEmailChanged
    )

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = name,
        label = "UserName",
        placeholder = "Enter your username",
        onValueChaged = onNameChanged
    )

    Spacer(modifier = Modifier.height(15.dp))

    DetailsFields(
        value = password,
        label = "Password(atleast 8 characters)",
        placeholder = "Enter your last name",
        onValueChaged = onPasswordChanged
    )

    Spacer(modifier = Modifier.height(15.dp))


    DetailsFields(modifier = modifier.fillMaxWidth(),
        value = confirmPassword,
        label = "ConfirmPassword(atleast 8 characters)",
        placeholder = "Enter Password",
        onValueChaged = onConfirmPasswordChanged,
        /*trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(

                        imageVector = Icons.Filled.Favorite ,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "hide_password"
                    )
                }
            }
        }*/
    )
    Spacer(modifier = Modifier.height(15.dp))

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsFields(
    modifier: Modifier = Modifier.fillMaxWidth(), value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChaged: (String) -> Unit
) {
    OutlinedTextField(
        shape = RoundedCornerShape(5.dp),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue,
            focusedLabelColor = Grey
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
        },
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon
    )

}
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AIWritingAssitanceTheme {
        Greeting2("Android")
    }
}