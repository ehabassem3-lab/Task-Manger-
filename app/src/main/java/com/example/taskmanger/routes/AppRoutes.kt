package com.example.taskmanger.routes

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable

    object SignInRoute : AppRoutes()
    @Serializable
    object  HomeTabRoute : AppRoutes()

    @Serializable
    object SignUpRoute : AppRoutes()

    @Serializable
    object  SplashScreenRoute : AppRoutes()
    @Serializable
    object  ForgetPasswordRoute : AppRoutes()
}