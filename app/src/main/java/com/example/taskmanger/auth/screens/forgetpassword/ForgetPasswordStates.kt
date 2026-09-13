package com.example.taskmanger.auth.screens.forgetpassword

import com.example.taskmanger.utilities.Resources

data class ForgetPasswordStates (
    val forgetPasswordApiState : Resources<Unit> = Resources.Idle ,
    val verifyCodeApiState : Resources<Unit> = Resources.Idle ,
    val email : String = "" ,
    val code   : String= ""
)

sealed class ForgetPasswordEvents{
    data class  onEmailChange(val email : String) : ForgetPasswordEvents()
    data class onCodeChange(val code : String) : ForgetPasswordEvents()
    object onResetPasswordClick : ForgetPasswordEvents()
    object onVerifyCodeClick : ForgetPasswordEvents()
}
