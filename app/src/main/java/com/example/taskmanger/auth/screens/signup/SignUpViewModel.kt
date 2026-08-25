package com.example.taskmanger.auth.screens.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {
    val state : MutableStateFlow<SignUpStates> = MutableStateFlow(SignUpStates())


    fun onEvent(event: SignUpEvents){
        when(event){
            is SignUpEvents.onEmailChange -> {
                state.value = state.value.copy(email =  event.email)
            }
            is SignUpEvents.onPassWordChange ->{
                state.value = state.value.copy(password = event.password)
            }
            is SignUpEvents.onPhoneChange -> {
                state.value = state.value.copy(phone = event.phone)
            }
            is SignUpEvents.onRoleChange -> {
                state.value =state.value.copy(role =  event.role)
            }
        }
    }



}