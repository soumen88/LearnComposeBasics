package com.learn.compose.basics.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.compose.basics.R
import com.learn.compose.basics.ui.theme.BlueColor

@Composable
fun ExplorerScreen(){
    val placesList = PlaceData().getPlaceDetails()

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.Black
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = BlueColor,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .requiredHeight(150.dp)
                ){
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "You are seeing the explorer screen",
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(placesList.size) { index ->
                    val place = placesList[index]
                    // INSERT_YOUR_CODE

                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        border = BorderStroke(width = 1.dp, color = Color.LightGray),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = place.name,
                                    color = BlueColor,
                                    style = TextStyle(
                                        fontSize = 24.sp
                                    )
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 24.dp),
                                    contentAlignment = Alignment.TopEnd
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.mountain),
                                        contentDescription = "Mountain",
                                        modifier = Modifier
                                            .size(69.dp)
                                    )
                                }
                            }
                            Text(text = "City: ${place.cityName}", modifier = Modifier.padding(top = 4.dp))
                            Text(text = "Altitude: ${place.altitude} m", modifier = Modifier.padding(top = 4.dp))
                            Text(text = place.description, modifier = Modifier.padding(top = 8.dp))
                        }
                    }
                }
            }
            }
        }
    )
}