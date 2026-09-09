package com.example.taskmanger.auth.screens.forgetpassword

import com.example.taskmanger.utilities.Resources

data class ForgetPasswordStates (
    val forgetPasswordApiState : Resources<Unit> = Resources.Idle ,
    val email : String = "" ,
)

sealed class ForgetPasswordEvents{
    data class  onEmailChange(val email : String) : ForgetPasswordEvents()
}
