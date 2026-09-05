package com.example.taskmanger.manger.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taskmanger.auth.screens.signin.SignInEvents
import com.example.taskmanger.auth.screens.signin.SignInViewModel
import com.example.taskmanger.ui.theme.Primary
import com.example.taskmanger.ui.theme.Secondary

@Composable
fun HomeTabView(
    viewModel: SignInViewModel = hiltViewModel()
){

    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black).clickable{
             viewModel.onEvent(SignInEvents.onSignOut)
        }

    ){

    }
}