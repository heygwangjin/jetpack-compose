package com.example.tutorial.ui.theme.chat

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.R
import com.example.tutorial.ui.theme.TutorialTheme

@Composable
fun MessageInput(
    msg: String,
    onMessageSent: (String) -> Unit,
    onMessageChange: (String) -> Unit,
) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.Bottom,
    ) {
        TextField(
            modifier = Modifier.weight(0.8f),
            value = msg,
            onValueChange = onMessageChange,
            maxLines = 3,
            label = { Text(text = stringResource(R.string.enter_message)) }
        )
        Button(
            modifier = Modifier.weight(0.2f),
            onClick = { onMessageSent(msg) }
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    imageVector = Icons.Filled.Send,
                    contentDescription = "send icon",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                )
                Text(text = stringResource(R.string.send))
            }
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
fun PreviewMessageInput() {
    TutorialTheme {
        MessageInput(
            msg = "메세지를 보내봐요.",
            onMessageSent = {},
            onMessageChange = {}
        )
    }
}