package com.learn.compose.basics.common


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.learn.compose.basics.ui.theme.OrangeColor

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAppBar(
    screenName : String,
    onBackButtonPress : (() -> Unit) ?= null
){
    TopAppBar(
        title = {
            Text(text = screenName)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = OrangeColor,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            if(onBackButtonPress != null){
                IconButton(
                    onClick = {
                        onBackButtonPress()
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }
    )
}