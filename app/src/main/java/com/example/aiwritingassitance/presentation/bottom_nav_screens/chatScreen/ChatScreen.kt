package com.example.aiwritingassitance.presentation.bottom_nav_screens.chatScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aiwritingassitance.R
import com.example.aiwritingassitance.presentation.navigation.Screens


//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "CHAT",
                        style = TextStyle(
//                color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontSize = 19.sp,
                            fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                        )
                    )
                },
            )
        },

        ) {
        Column(
            modifier = modifier.padding(it)
        ) {
//            Text(text = "ITEMS")
//            Text(text = "ITEMS")
//            Text(text = "ITEMS")
//            Text(text = "ITEMS")
            OptionsListItem(
                title = "Email Writer",
                icon = R.drawable.email,
                bgkColor = Color(0xFF1165E4),
                onClick = {
                    navController.navigate(Screens.EmailScreen.name)
                }
            )
            OptionsListItem(
                title = "Article Writer",
                icon = R.drawable.baseline_article_24,
                bgkColor = Color(0xFF157E15),
                onClick = {
                    navController.navigate(Screens.ArticlesScreen.name)
                }
            )
            OptionsListItem(
                title = "Essay Writer",
                icon = R.drawable.essay,
                bgkColor = Color(0xFFff6600),
                onClick = {
                    navController.navigate(Screens.EssaysScreen.name)
                }
            )
            OptionsListItem(
                title = "Grammar Checker",
                icon = R.drawable.baseline_language_24,
                bgkColor = Color(0xFF999900),
                onClick = {
                    navController.navigate(Screens.GrammarCheckScreen.name)
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun OptionsListItem(
    modifier: Modifier = Modifier,
    title: String = "Email Writer",
    subTitle: String = "Write Compelling emails",
    icon: Int = R.drawable.baseline_article_24,
    bgkColor: Color = Color.Blue,
    onClick: () -> Unit = {},
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = bgkColor,
        ),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(

            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color(0xFFFFFFFF),
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W600,
                        fontSize = 17.sp,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                contentDescription = null,
                tint = Color(0xFFFFFFFF),
            )
        }


    }

}


//Color(0xFF80A0FF)