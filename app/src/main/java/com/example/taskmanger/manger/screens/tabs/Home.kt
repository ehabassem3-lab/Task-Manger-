package com.example.taskmanger.manger.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.taskmanger.auth.screens.signin.SignInEvents
import com.example.taskmanger.auth.screens.signin.SignInViewModel
import com.example.taskmanger.routes.AppRoutes
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary
import com.example.taskmanger.utilities.Resources

@Composable
fun HomeTabView(
    navController: NavController ,
    viewModel: SignInViewModel = hiltViewModel() ,
){
    val s = viewModel.state.collectAsStateWithLifecycle().value.signOutApi
    LaunchedEffect( s) {
        when(s){
            is Resources.Error -> {}
            Resources.Idle ->     {}
            Resources.Loading ->  {}
            is Resources.Success<Unit> -> {
                navController.navigate(AppRoutes.SignInRoute)

            }
        }

    }

    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black).clickable{
             viewModel.onEvent(SignInEvents.onSignOut)
        }

    ){

    }
}