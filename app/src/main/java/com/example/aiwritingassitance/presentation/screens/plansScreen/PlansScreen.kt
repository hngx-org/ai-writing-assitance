package com.example.aiwritingassitance.presentation.screens.plansScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.navigation.NavController
import com.example.aiwritingassitance.R


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun PlansScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val scrollState = rememberScrollState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = "Plans",
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
        Column(
            modifier = modifier.padding(it).verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            PlanItem(
                planName = "Basic Plan",
                price = "FREE",
                btnDesc = "FREE",
                benefit2 = "Standard Response Speed",
                benefit1 = "Base Model",
                benefit3 = "Frequent Updates"
            )
            PlanItem(
                planName = "Pro Plan",
                price = "NGN 250/mo",
                btnDesc = "Upgrade to Pro",
                benefit2 = "Professional Plan",
                benefit1 = "2x Faster Responses",
                benefit3 = "Access to Plugins"
            )
            PlanItem(
                planName = "Premium Plan",
                price = "NGN 350/mo",
                btnDesc = "Upgrade to Premium",
                benefit2 = "More Personalized Responses",
                benefit1 = "Better Details",
                benefit3 = "Frequent Updates"
            )
//            PlanItem(
//                planName = "Ultimate Plan",
//                price = "NGN 400/mo",
//                btnDesc = "Upgrade to Ultimate",
//                benefit2 = "Standard Response Speed",
//                benefit1 = "Base Model",
//                benefit3 = "Frequent Updates"
//            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PlanItem(
    modifier: Modifier = Modifier,
    planName: String = "Basic Plan",
    benefit1: String = "Added Points",
    benefit2: String = "Added Points",
    benefit3: String = "Added Points",
    btnColor: Color = Color(0xFF133896),
    btnDesc: String = "Upgrade to plus",
    price: String = "NGN 500/mo",
    onClick: () -> Unit = {},
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = planName,
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 23.sp,
                        fontFamily = FontFamily(Font(R.font.spacegrotesk_semibold))
                    )
                )
                Text(
                    text = price,
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.spacegrotesk_medium)),
                        color = Color.Gray
                    )
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    containerColor = btnColor,
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = btnDesc,
                        modifier = Modifier.padding(10.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.W600,
//                        fontSize = 17.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    )
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
//                        contentDescription = null,
//                        tint = Color(0xFFFFFFFF)
//                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = benefit1,
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = benefit2,
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = benefit3,
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}