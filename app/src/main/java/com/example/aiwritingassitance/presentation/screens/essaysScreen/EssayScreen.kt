package com.example.aiwritingassitance.presentation.screens.essaysScreen

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
import androidx.navigation.NavController
import com.example.aiwritingassitance.R
import com.example.aiwritingassitance.presentation.screens.common.PageContent


//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EssayScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = "Essay Writer",
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
            pgName = "Essay",
            pgTitle = "Essay Perfection at your Fingertips",
            inputLabel = "e.g Digital Privacy Concerns",
            btnColor = Color(0xFFff6600),
        ) { essay ->
//            viewModel.getEssay(essay)
        }
    }
}