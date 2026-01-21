package com.learn.compose.basics.splash
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.compose.basics.R
import com.learn.compose.basics.common.DisplayCustomButton

@Composable
fun SplashScreen(
    showNextScreen : (String) -> Unit
){
    val TAG = "SplashScreen"
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to the app",
                    style = TextStyle(
                        fontSize = 28.sp
                    )
                )
                Text(
                    text = "Mountain Wanderer",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null
                )
                Spacer(
                    modifier = Modifier.height(
                        200.dp
                    )
                )
                DisplayCustomButton(
                    buttonCaption = "Join as a Hiker",
                    onButtonPress = {
                        Log.d(TAG, "User has clicked to join as a hiker")
                        showNextScreen("Hiker - A person who is confident and now can hike up a mountain")
                    }
                )
                DisplayCustomButton(
                    buttonCaption = "Explore nearby Hiking Destinations",
                    onButtonPress = {
                        Log.d(TAG, "User has clicked to explore nearby hiking destinations")
                        showNextScreen("Explorer - A person who would want to research about hiking destinations and then make a decision to join")
                    }
                )
            }
        }
    )
}