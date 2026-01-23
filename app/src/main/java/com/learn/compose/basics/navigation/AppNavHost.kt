package com.learn.compose.basics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.learn.compose.basics.home.HomeScreen
import com.learn.compose.basics.splash.SplashScreen
import com.learn.compose.basics.tabs.TabScreen

class AppNavHost {

    @Composable
    fun SetupAppNavHost(
        hostController : NavHostController,
        startDestinationScreen : String = ScreenEnums.TabsScreen.name
    ){
        NavHost(
            navController =  hostController,
            startDestination = startDestinationScreen,
        ){
            DisplaySplashScreen(
                hostController = hostController,
                navGraphBuilder = this
            )
            DisplayHomeScreen(
                hostController = hostController,
                navGraphBuilder = this
            )
            DisplayTabsScreen(
                hostController = hostController,
                navGraphBuilder = this
            )
        }
    }

    fun DisplaySplashScreen(
        hostController : NavHostController,
        navGraphBuilder : NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.SplashScreen.name
        ){
            SplashScreen(
                showNextScreen = { dataToBeShared ->
                    hostController.navigate("${ScreenEnums.HomeScreen.name}/$dataToBeShared")
                }
            )
        }
    }

    fun DisplayHomeScreen(
        hostController : NavHostController,
        navGraphBuilder : NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = "${ScreenEnums.HomeScreen.name}/{dataToBeShared}",
            arguments = listOf(
                navArgument("dataToBeShared"){type= NavType.StringType}
            )
        ){ backStackEntry->
            val dataReceived = backStackEntry.arguments?.getString("dataToBeShared").orEmpty()
            HomeScreen(dataReceivedFromSplash = dataReceived)
        }
    }

    fun DisplayTabsScreen(
        hostController : NavHostController,
        navGraphBuilder : NavGraphBuilder
    ){
        navGraphBuilder.composable(
            route = ScreenEnums.TabsScreen.name,
        ){ backStackEntry->
            TabScreen()
        }
    }
}