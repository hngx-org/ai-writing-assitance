package com.example.aiwritingassitance

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aiwritingassitance.presentation.bottom_nav_screens.AccountDestination
import com.example.aiwritingassitance.presentation.bottom_nav_screens.AccountScreen
import com.example.aiwritingassitance.presentation.bottom_nav_screens.ChatDestination
import com.example.aiwritingassitance.presentation.bottom_nav_screens.HomeDestination
import com.example.aiwritingassitance.presentation.bottom_nav_screens.HomeScreen
import com.example.aiwritingassitance.presentation.bottom_nav_screens.allDestinations
import com.example.aiwritingassitance.presentation.navigation.Screens
import com.example.aiwritingassitance.presentation.screens.articlesScreen.ArticlesScreen
import com.example.aiwritingassitance.presentation.bottom_nav_screens.chatScreen.ChatScreen
import com.example.aiwritingassitance.presentation.screens.ChatViewModel
import com.example.aiwritingassitance.presentation.screens.articlesScreen.ArticleViewModel
import com.example.aiwritingassitance.presentation.screens.emailScreen.EmailScreen
import com.example.aiwritingassitance.presentation.screens.emailScreen.EmailViewModel
import com.example.aiwritingassitance.presentation.screens.essaysScreen.EssayScreen
import com.example.aiwritingassitance.presentation.screens.essaysScreen.EssayViewModel
import com.example.aiwritingassitance.presentation.screens.grammarCheckScreen.GrammarCheckScreen
import com.example.aiwritingassitance.presentation.screens.grammarCheckScreen.GrammarCheckViewModel
import com.example.aiwritingassitance.presentation.screens.plansScreen.CheckoutScreen
import com.example.aiwritingassitance.presentation.screens.plansScreen.PlansScreen
import com.example.aiwritingassitance.ui.theme.AIWritingAssitanceTheme


@OptIn(ExperimentalMaterial3Api::class)
class BottomNavigationActivity : ComponentActivity() {

    private var selectedItem by mutableStateOf(0)

    val chatViewModel by viewModels<ChatViewModel>()
    val emailViewModel by viewModels<EmailViewModel>()
    val articleViewModel by viewModels<ArticleViewModel>()
    val essayViewModel by viewModels<EssayViewModel>()
    val grammarCheckViewModel by viewModels<GrammarCheckViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authService = AuthService(applicationContext)


            val intent = intent
            var userId = intent.getStringExtra("UserId")
            var userEmail = intent.getStringExtra("UserEmail")
            var  userName = intent.getStringExtra("UserName")
            var userCredit = intent.getStringExtra("UserCredit")
            var userCookies = intent.getStringExtra("UserCookies")

            if (userCookies != null) {
                Log.d("ApiResponseResult", userCookies)
            }





            AIWritingAssitanceTheme {
                var navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            allDestinations.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = item.route
                                        )
                                    },
                                    label = { Text(text = item.label) },
                                    selected = selectedItem == index,
                                    onClick = {
                                        selectedItem = index
                                        navController.navigate(item.route) {
//                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
//                                            launchSingleTop = true
//                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }

                ) {
                    NavHost(
                        navController = navController,
                        startDestination = HomeDestination.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(HomeDestination.route) {
                            HomeScreen(
                                navController = navController,
                                onNavigateToReward = {
                                    selectedItem = 1
                                }
                            )
                        }
                        composable(ChatDestination.route) { ChatScreen(navController = navController) }
                        composable(AccountDestination.route) { AccountScreen(authService = authService, context = this@BottomNavigationActivity)}


                        //richard
                        composable(route = Screens.MiddleScreen.name) {
                            ChatScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screens.EmailScreen.name) {
                            EmailScreen(
                                navController = navController,
                                viewModel = emailViewModel,
                            )
                        }
                        composable(route = Screens.ArticlesScreen.name) {
                            ArticlesScreen(
                                navController = navController,
                                // TODO:
                                viewModel = articleViewModel,
                                userId = userId!!,
                            )
                        }
                        composable(route = Screens.EssaysScreen.name) {
                            EssayScreen(
                                navController = navController,
                                viewModel = essayViewModel,
                            )
                        }
                        composable(route = Screens.GrammarCheckScreen.name) {
                            GrammarCheckScreen(
                                navController = navController,
                                viewModel = grammarCheckViewModel,
                            )
                        }


                        composable(route = Screens.PlansScreen.name) {
                            PlansScreen(navController = navController)
                        }
                        composable(route = Screens.CheckoutScreen.name) {
                            CheckoutScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

