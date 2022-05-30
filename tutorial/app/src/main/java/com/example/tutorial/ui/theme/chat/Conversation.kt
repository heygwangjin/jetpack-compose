package com.example.tutorial.ui.theme.chat

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.Message
import com.example.tutorial.SampleData
import com.example.tutorial.ui.theme.TutorialTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(
        content = {
            items(messages) { message ->
                MessageCard(msg = message)
            }
        }
    )
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewConversation() {
    TutorialTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}