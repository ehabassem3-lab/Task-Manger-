package com.example.taskmanger.auth.screens.forgetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanger.auth.domain.AuthRepository
import com.example.taskmanger.utilities.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
   private val authRepository: AuthRepository
) : ViewModel() {
    val state: MutableStateFlow<ForgetPasswordStates> = MutableStateFlow(ForgetPasswordStates())


    fun onEvent(event: ForgetPasswordEvents) {
        when (event) {
            is ForgetPasswordEvents.onEmailChange -> {
                state.value = state.value.copy(email = event.email)
            }

            is ForgetPasswordEvents.onCodeChange -> {
                state.value = state.value.copy(code = event.code)
            }

            ForgetPasswordEvents.onResetPasswordClick -> resetPassword()
            ForgetPasswordEvents.onVerifyCodeClick -> verifyCode()
        }

    }

    private fun verifyCode() {
        viewModelScope.launch {
            state.value = state.value.copy(verifyCodeApiState = Resources.Loading)
            val verify = authRepository.verifyCode(state.value.code)
            if (verify.isSuccess) {
                state.value =
                    state.value.copy(verifyCodeApiState = Resources.Success(verify.getOrNull()))
            } else {
                state.value =
                    state.value.copy(verifyCodeApiState = Resources.Error(Throwable(verify.exceptionOrNull())))
            }
        }
    }

    private fun resetPassword() {
        viewModelScope.launch {
            state.value = state.value.copy(forgetPasswordApiState = Resources.Loading)
            val resetPassword = authRepository.forgetPassword(state.value.email)
            if (resetPassword.isSuccess) {
                state.value =
                    state.value.copy(forgetPasswordApiState = Resources.Success(resetPassword.getOrNull()))
            } else {
                state.value = state.value.copy(
                    forgetPasswordApiState = Resources.Error(
                        Throwable(resetPassword.exceptionOrNull())
                    )
                )
            }
        }
    }


}