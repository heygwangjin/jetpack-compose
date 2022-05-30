package com.example.tutorial.ui.theme.chat

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.Message
import com.example.tutorial.ui.theme.TutorialTheme

@Composable
fun ChatScreen() {
    var messages by rememberSaveable { mutableStateOf(listOf<Message>()) }
    var message by rememberSaveable { mutableStateOf("") }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar =  {
            MessageInput(
                msg = message,
                onMessageSent = {
                    if (it.isNotEmpty()) {
                        messages = messages + listOf(Message("Gwangjin", it))
                        message = ""
                    }
                },
                onMessageChange = { message = it }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Conversation(messages = messages)
        }
    }
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
fun PreviewChatScreen() {
    TutorialTheme {
        ChatScreen()
    }
}