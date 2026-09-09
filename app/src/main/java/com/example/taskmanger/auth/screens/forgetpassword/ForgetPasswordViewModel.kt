package com.example.taskmanger.auth.screens.forgetpassword

import androidx.lifecycle.ViewModel
import com.example.taskmanger.auth.di.domain.AuthRepository
import com.example.taskmanger.utilities.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class ForgetPasswordViewModel  @Inject constructor(
     val authRepository: AuthRepository
) : ViewModel(){
    val state  : MutableStateFlow<ForgetPasswordStates> = MutableStateFlow(ForgetPasswordStates())


    fun onEvent(event: ForgetPasswordEvents){
        when(event){
            is ForgetPasswordEvents.onEmailChange -> {state.value =state.value.copy(email =  event.email)}
        }

    }





}