package com.example.taskmanger.auth.screens.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanger.auth.domain.AuthRepository
import com.example.taskmanger.utilities.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.request.request
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
   private  val authRepository: AuthRepository
) : ViewModel() {
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

            is SignInEvents.SignInClick -> signIn(event.email,event.password)
            SignInEvents.onSignOut -> signOut()
        }

    }

    private fun signOut() {
        viewModelScope.launch {
            state.value = state.value.copy(signOutApi = Resources.Loading)
           val logOut =  authRepository.signOut()
            if (logOut.isSuccess){
                state.value =state.value.copy(signOutApi = Resources.Success(Unit))
            }else{
                state.value =state.value.copy(signOutApi = Resources.Error(Throwable(logOut.exceptionOrNull())))
            }
        }
    }

    private fun signIn(email: String, password: String) {
         viewModelScope.launch {
              state.value =state.value.copy(signInApi =  Resources.Loading)
             val request = authRepository.signIn(email,password)
             if(request.isSuccess){

                 state.value =state.value.copy(signInApi =  Resources.Success(request.getOrNull()))


             }else{
                 state.value =state.value.copy(signInApi =  Resources.Error(Throwable(request.exceptionOrNull())))

             }



         }
    }


}