package com.example.aiwritingassitance.presentation.screens.articlesScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.aiwritingassitance.presentation.screens.ChatViewModel
import com.example.aiwritingassitance.presentation.screens.common.PageContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ArticleViewModel,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = "Article Writer",
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
            pgName = "Article",
            pgTitle = "Write Brilliant Articles Effortlessly",
            viewModel = viewModel,
            inputLabel = "e.g 10 Tips for productive Remote Work",
            btnColor = Color(0xFF157E15),
            response = viewModel.articleResponse
        ){
            viewModel.getArticleResponse(prompt = viewModel.articleTopic, userId = "")
        }

//        Column(modifier.padding(it)) {
//            Button(onClick = { viewModel.getResponse() }) {
//                Text(
//                    text = "Print",
//                )
//            }
//            Text(text = viewModel.response)
//        }

    }

}