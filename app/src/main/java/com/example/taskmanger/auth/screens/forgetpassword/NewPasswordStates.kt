package com.example.taskmanger.auth.screens.forgetpassword

import com.example.taskmanger.utilities.Resources

data class NewPasswordStates (
    val newPasswordApiState  : Resources<Unit>  = Resources.Idle ,
    val  password : String = "" ,
    val rePassword : String = "" ,
)
