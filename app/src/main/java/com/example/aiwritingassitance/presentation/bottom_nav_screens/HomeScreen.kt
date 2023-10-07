package com.example.aiwritingassitance.presentation.bottom_nav_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aiwritingassitance.presentation.navigation.Screens
import com.example.aiwritingassitance.ui.theme.CardColor
import com.example.aiwritingassitance.ui.theme.DaisyBC
import com.example.aiwritingassitance.ui.theme.Green2
import com.example.aiwritingassitance.ui.theme.LightGrey
import com.example.aiwritingassitance.ui.theme.Neutral1
import com.example.aiwritingassitance.ui.theme.Neutral2
import com.example.aiwritingassitance.ui.theme.NewChatColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onNavigateToReward: () -> Unit,
    modifier: Modifier = Modifier,
    //viewModel: HomeViewModel = HomeViewModel(),
    userName: String,
    userCredit: String
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DaisyBC
    ) {

        Scaffold(
            topBar = {
                TopAppBar(

                    title = {

                        Column {
                            Text(
                                text = "Welcome! ",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )

                            Text(
                                text = "$userName ",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )
                        }

                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
                            modifier.size(30.dp),
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notication",
                            modifier.size(30.dp)
                        )
                    }
                )
            },
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                //.verticalScroll(rememberScrollState())
            ) {
                UpgradeAccount(navController)
                ActionButton(
                    onAIChatBuddyButtonClicked = { /*TODO*/ },
                    onNewChatButtonClicked = { /*TODO*/ },
                    onChatHistoryButtonClicked = { })

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Prompt Examples",
                    modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                LazyVerticalGrid(columns = GridCells.Fixed(count = 2),
                    content = {
                        items(items = Data.prompts) { item ->
                            PromptCards(modifier = modifier, promptMessage = item)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun UpgradeAccount(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(LightGrey)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 14.dp,
                    start = 16.dp,
                    end = 16.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Get a Premium plan",
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Enjoy the full power without limit!"
        )

        Button(
            onClick = {
                navController.navigate(Screens.CheckoutScreen.name)
//                navController.navigate(Screens.PlansScreen.name)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Green2
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = 14.dp,
                )
        ) {
            Text(text = "Upgrade Account")
        }
    }
}

@Composable
private fun ActionButton(
    onAIChatBuddyButtonClicked: () -> Unit,
    onNewChatButtonClicked: () -> Unit,
    onChatHistoryButtonClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
        //.background(Grey)
    ) {

        Button(
            onClick = { onAIChatBuddyButtonClicked },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Text(
                text = "AI Writing Assitance",
                color = Neutral1
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Icon(
                imageVector = Icons.Outlined.ArrowForward, contentDescription = "Proceed"
            )

        }

        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { onNewChatButtonClicked },
            colors = ButtonDefaults.buttonColors(
                containerColor = NewChatColor
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "proceed",
                tint = Neutral2
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "New Chat",
                color = Neutral2
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "proceed",
                tint = Neutral2
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { onChatHistoryButtonClicked },
            colors = ButtonDefaults.buttonColors(
                containerColor = LightGrey
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Icon(
                imageVector = Icons.Outlined.List,
                contentDescription = "proceed",
                tint = Neutral2
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Chat History",
                color = Neutral2
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "proceed",
                tint = Neutral2
            )
        }
    }
}

@Composable
fun PromptCards(modifier: Modifier, promptMessage: String) {
    Card(
        modifier
            .aspectRatio(1.7f)
            /*.clickable {
            }*/
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        )
    ) {
        Text(
            text = promptMessage,
            Modifier.padding(5.dp),
            color = Neutral2
        )
    }
}

