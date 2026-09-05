package com.example.taskmanger.auth.screens.signin

import com.example.taskmanger.utilities.Resources

data class SignInStates(
    val email : String = "" ,
    val password : String = "" ,
    val signInApi : Resources<Unit> = Resources.Idle


)



sealed class SignInEvents{
    data class onEmailChange (val email : String):  SignInEvents()
    data class  onPassWordChange ( val password : String) : SignInEvents()
    object  onCreateAccount  : SignInEvents()
    object  onForgertPassWrod : SignInEvents()
    data class SignInClick(val email : String , val password: String) : SignInEvents()
    object  onSignOut : SignInEvents()


}