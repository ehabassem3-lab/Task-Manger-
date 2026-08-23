package com.example.taskmanger.auth.screens.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {
    val state  : MutableStateFlow<SignInStates> = MutableStateFlow(SignInStates())


    fun onEvent(event: SignInEvents){
        when(event){
            SignInEvents.onCreateAccount -> {}
            is SignInEvents.onEmailChange -> {
                state.value= state.value.copy(email = event.email)
            }
            SignInEvents.onForgertPassWrod -> {}
            is SignInEvents.onPassWordChange -> {
                state.value= state.value.copy(password = event.password)
            }

        }

    }


}