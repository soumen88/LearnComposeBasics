package com.learn.compose.basics.home

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.learn.compose.basics.R
import com.learn.compose.basics.common.DisplayTopBar

@Composable
fun HomeScreen(
    dataReceivedFromSplash : String
){
    val allPagesCount = 3
    val pagerState = rememberPagerState(
        pageCount = {allPagesCount}
    )
    val imagesList = mutableListOf<Int>(
        R.drawable.page_one,
        R.drawable.page_two,
        R.drawable.page_three,
    )
    val paddingValues = WindowInsets.navigationBars.asPaddingValues()
    Scaffold(
        topBar = {
            DisplayTopBar(
                screenName = "Home Screen",
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Home screen is displayed - \n $dataReceivedFromSplash"
                )
                HorizontalPager(state = pagerState) {
                    Image(
                        painter = painterResource( imagesList[pagerState.currentPage]),
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(paddingValues),
                horizontalArrangement = Arrangement.Center,
            ) {
                repeat(allPagesCount){ iteration ->
                    val colorToCircle = if(iteration == pagerState.currentPage){
                        Color.Black
                    }
                    else{
                        Color.Gray
                    }
                    Box(
                        modifier = Modifier.size(20.dp)
                            .padding(end = 10.dp)
                            .background(colorToCircle, CircleShape)
                    )
                }
            }
        }
    )
}