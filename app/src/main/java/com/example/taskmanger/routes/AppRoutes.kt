package com.example.taskmanger.routes

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    object SignInRoute : AppRoutes()
}