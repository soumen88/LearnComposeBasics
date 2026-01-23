package com.learn.compose.basics.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.learn.compose.basics.home.HomeScreen

@Composable
fun TabScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Home", "About", "Settings")

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(paddingValues)
            ) {
                PrimaryTabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            icon = {
                                when (index) {
                                    0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                                    1 -> Icon(imageVector = Icons.Default.Info, contentDescription = null)
                                    2 -> Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                                }
                            }
                        )
                    }
                }
                when (tabIndex) {
                    0 -> HomeScreen(
                        dataReceivedFromSplash = "Home screen is seen here"
                    )
                    1 -> AboutScreen()
                    2 -> SettingsScreen()
                }
            }
        }
    )
}