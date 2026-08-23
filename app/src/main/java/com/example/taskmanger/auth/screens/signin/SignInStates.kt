package com.example.taskmanger.auth.screens.signin

data class SignInStates(
    val email : String = "" ,
    val password : String = ""


)



sealed class SignInEvents{
    data class onEmailChange (val email : String):  SignInEvents()
    data class  onPassWordChange ( val password : String) : SignInEvents()
    object  onCreateAccount  : SignInEvents()
    object  onForgertPassWrod : SignInEvents()


}