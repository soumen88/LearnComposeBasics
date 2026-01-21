package com.learn.compose.basics.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DisplayCustomButton(
    buttonCaption : String,
    onButtonPress : () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp
            ),
        onClick = {
            onButtonPress()
        }
    ) {
        Text(text = buttonCaption)
    }
}