package com.learn.compose.basics.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
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
import androidx.compose.ui.unit.dp
import com.learn.compose.basics.R
import com.learn.compose.basics.common.DisplayAppBar

@Composable
fun HomeScreen(
    dataReceivedFromSplash : String
){
    val TAG = "Homescreen"
    var tabIndex by remember { mutableStateOf(1) }
    val tabs = listOf<String>("Hiker", "Explorer")
    if(dataReceivedFromSplash == "Hiker - A person who is confident and now can hike up a mountain"){
        tabIndex = 0
    }
    else{
        tabIndex = 1
    }
    Scaffold(
        topBar = {
            DisplayAppBar(
                screenName = "Home",
                /*onBackButtonPress = {
                    Log.d("HomeScreen", "Back button was pressed")
                }*/
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(paddingValues)
            ) {
                PrimaryTabRow(selectedTabIndex =  tabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Log.d(TAG, "Index $index and title $title")
                        Tab(
                            text = {
                                Text(title)
                            },
                            selected = tabIndex == index,
                            onClick = {
                                tabIndex = index
                            },
                            icon = {
                                when(index){
                                    0 -> Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null
                                    )
                                    1->Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    }
                }
                when(tabIndex){
                    0 -> HikerScreen()
                    1 -> ExplorerScreen()
                }
            }
        }
    )
}