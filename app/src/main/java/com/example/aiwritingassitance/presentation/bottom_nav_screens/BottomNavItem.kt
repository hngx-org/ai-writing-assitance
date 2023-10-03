package com.example.aiwritingassitance.presentation.bottom_nav_screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavItem {
    val route: String
    val label: String
    val icon: ImageVector
}

object HomeDestination: BottomNavItem {
    override val route: String = "home"
    override val icon: ImageVector = Icons.Outlined.Home
    override val label: String = "Home"
}

object ChatDestination: BottomNavItem {
    override val route: String = "chat"
    override val icon: ImageVector = Icons.Outlined.MailOutline
    override val label: String = "Chat"
}

object AccountDestination: BottomNavItem {
    override val route: String = "account"
    override val label: String = "Account"
    override val icon: ImageVector = Icons.Outlined.Person
}

val allDestinations = listOf(
    HomeDestination,
    ChatDestination,
    AccountDestination
)