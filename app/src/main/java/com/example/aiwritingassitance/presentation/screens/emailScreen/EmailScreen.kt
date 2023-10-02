package com.example.aiwritingassitance.presentation.screens.emailScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aiwritingassitance.R
import com.example.aiwritingassitance.presentation.screens.common.PageContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = "Email Writer",
                        style = TextStyle(
//                color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontSize = 19.sp,
                            fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                        )
                    )
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        },
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        PageContent(
            modifier = modifier.padding(it),
            pgName = "Email",
            pgTitle = "Elevate your email game: Write smarter not harder",
            topicLabel = "e.g Resignation Letter",
            toLabel = "e.g My Boss",
            btnColor = Color(0xFF1165E4),
        )
    }
}