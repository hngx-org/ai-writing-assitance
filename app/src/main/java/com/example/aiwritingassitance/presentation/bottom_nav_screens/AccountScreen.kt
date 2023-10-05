package com.example.aiwritingassitance.presentation.bottom_nav_screens

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aiwritingassitance.AuthService
import com.example.aiwritingassitance.BottomNavigationActivity
import com.example.aiwritingassitance.R
import com.example.aiwritingassitance.SignUpActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AccountScreen(context: BottomNavigationActivity, authService: AuthService) {
    var darkMode by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(100.dp)
                .clip(
                    CircleShape
                )
                .padding(top = 8.dp)
        )
        Text(text = "John Doe", style = MaterialTheme.typography.headlineMedium)
        Text(text = "johndoe@gmail.com", style = MaterialTheme.typography.bodyLarge)

        LazyColumn(){
            item {
                SwitchSetting(title = "Dark Mode", isChecked = darkMode, onCheckedChange = {
                    darkMode = it
                    setDarkMode(darkMode)
                })
            }
            item {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Profile", modifier = Modifier.weight(1f), style = MaterialTheme.typography.headlineSmall)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Profile" )
                    }
                }
            }
            item {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Settings", modifier = Modifier.weight(1f), style = MaterialTheme.typography.headlineSmall)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Profile" )
                    }
                }
            }
            item {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
                    .clickable { CoroutineScope(Dispatchers.IO).launch {
                        authService.loginOut()
                        val intent =Intent(context, SignUpActivity::class.java)
                        context.startActivity(intent)
                        Log.d("ApiResponseResult", "Goooo")
                    } },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Logout", modifier = Modifier.weight(1f), style = MaterialTheme.typography.headlineSmall)
                    IconButton(onClick = {
                        Log.d("ApiResponseResult", "Goooo")
                        CoroutineScope(Dispatchers.IO).launch {
                            authService.loginOut()
                            val intent =Intent(context, SignUpActivity::class.java)
                            context.startActivity(intent)
                            Log.d("ApiResponseResult", "Goooo")
                        }

                    }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Profile" )
                    }
                }
            }
        }

    }
}

@Composable
fun SwitchSetting(title: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit){
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Dark Mode", modifier = Modifier.weight(1f), style = MaterialTheme.typography.headlineSmall)
        Switch(checked = isChecked, onCheckedChange = onCheckedChange,
            modifier =  Modifier.padding(start = 16.dp))
    }
}

fun setDarkMode(enableDarkMode: Boolean) {
    val mode = if (enableDarkMode) {
        AppCompatDelegate.MODE_NIGHT_YES
    } else {
        AppCompatDelegate.MODE_NIGHT_NO
    }
    AppCompatDelegate.setDefaultNightMode(mode)
}

@Preview(showBackground = true)
@Composable
fun PreviewAccountScreen(){
   // AccountScreen()
}