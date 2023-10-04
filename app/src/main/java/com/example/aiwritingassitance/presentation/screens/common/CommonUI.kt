package com.example.aiwritingassitance.presentation.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.aiwritingassitance.R


/**General UI*/
@Preview(showSystemUi = true)
@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    pgName: String = "Email",
    pgTitle: String = "A simple one click email generator",
    inputLabel: String = "e.g Generate an email to my boss",
    btnColor: Color = Color(0xFF0D2777),
    onGenerateClick: (String) -> Unit = {},
) {

    var userInput by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(scrollState),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pgTitle,
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 21.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_bold))
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
//                .fillMaxWidth(),
        ) {
            Text(
                text = "Topic",
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {},
                value = userInput,
                label = inputLabel,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

//        Button(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Generate Email")
//        }
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    // TODO:
//                           onGenerateClick(pass topic string here)
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
                    text = "Generate $pgName",
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W600,
//                        fontSize = 17.sp,
                        fontFamily = FontFamily.Monospace
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Generated $pgName",
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
            )
        )
        Divider()
        Icon(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 5.dp)
                .clickable {

                },
            painter = painterResource(id = R.drawable.baseline_content_copy_24),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_light))
            ),
            text = "Use System Prompts:\n" +
                    "\n" +
                    "OpenAI provides a set of system prompts that are designed to be used with the chat models. You can use these as a starting point and add your specific instructions.\n" +
                    "Iterate and Experiment:\n" +
                    "\n" +
                    "It may take some experimentation to get the desired output. Feel free to iterate on your prompts and instructions to fine-tune the model's responses.\n" +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content." +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content."
        )
    }
}


/**
 * For Email Screen*/
@Preview(showSystemUi = true)
@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    pgName: String = "Email",
    pgTitle: String = "A simple one click email generator",
    topicLabel: String = "e.g Resignation Letter",
    toLabel: String = "e.g My Boss",
    btnColor: Color = Color(0xFF0D2777),
    onGenerateClick: (String) -> Unit = {},
) {

    var userInput by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(scrollState),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pgTitle,
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 21.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_bold))
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
//                .fillMaxWidth(),
        ) {
            Text(
                text = "Topic",
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {},
                value = userInput,
                label = topicLabel,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Destination",
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {},
                value = userInput,
                label = toLabel,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

//        Button(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Generate Email")
//        }
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    // TODO:
//                           onGenerateClick(pass topic string here)
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
                    text = "Generate $pgName",
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W600,
//                        fontSize = 17.sp,
                        fontFamily = FontFamily.Monospace
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Generated $pgName",
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
            )
        )
        Divider()
        Icon(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 5.dp)
                .clickable {

                },
            painter = painterResource(id = R.drawable.baseline_content_copy_24),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_light))
            ),
            text = "Use System Prompts:\n" +
                    "\n" +
                    "OpenAI provides a set of system prompts that are designed to be used with the chat models. You can use these as a starting point and add your specific instructions.\n" +
                    "Iterate and Experiment:\n" +
                    "\n" +
                    "It may take some experimentation to get the desired output. Feel free to iterate on your prompts and instructions to fine-tune the model's responses.\n" +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content." +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content."
        )
    }
}



/**
 * For Grammar Checker*/
@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    pgTitle: String = "A simple one click email generator",
    inputLabel: String = "e.g Generate an email to my boss",
    btnColor: Color = Color(0xFF0D2777),
    onGenerateClick: (String) -> Unit = {},
) {

    var userInput by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(scrollState),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = pgTitle,
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 21.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_bold))
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
//                .fillMaxWidth(),
        ) {
            Text(
                text = "text",
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
                )
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {},
                value = userInput,
                label = inputLabel,
                maxLines = maxLines,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

//        Button(
//            onClick = { /*TODO*/ },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Generate Email")
//        }
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    // TODO:
//                           onGenerateClick(pass topic string here)
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
                    text = "Check & Refactor",
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.W600,
//                        fontSize = 17.sp,
                        fontFamily = FontFamily.Monospace
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Refined Text",
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_medium))
            )
        )
        Divider()
        Icon(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 5.dp)
                .clickable {

                },
            painter = painterResource(id = R.drawable.baseline_content_copy_24),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
//                color = Color.White,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.spacegrotesk_light))
            ),
            text = "Use System Prompts:\n" +
                    "\n" +
                    "OpenAI provides a set of system prompts that are designed to be used with the chat models. You can use these as a starting point and add your specific instructions.\n" +
                    "Iterate and Experiment:\n" +
                    "\n" +
                    "It may take some experimentation to get the desired output. Feel free to iterate on your prompts and instructions to fine-tune the model's responses.\n" +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content." +
                    "Evaluate and Filter Responses:\n" +
                    "\n" +
                    "After receiving responses, you can post-process and filter them to ensure they meet your requirements for tone and topic. You can also add a feedback loop to improve the model's performance over time.\n" +
                    "Remember that prompt engineering may require some trial and error to find the right balance of instructions and constraints. Additionally, it's essential to stay within the ethical boundaries and guidelines when using AI models to generate content."
        )
    }
}








@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    label: String,
    maxLines: Int = 1,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        label = { Text(text = label) },
        keyboardActions = KeyboardActions.Default,
    )

}
