package com.learn.compose.basics.navigation

sealed class NavigationItem (val route : String){
    object SplashScreen : NavigationItem(ScreenEnums.SplashScreen.name)
    object HomeScreen : NavigationItem(ScreenEnums.HomeScreen.name)
}