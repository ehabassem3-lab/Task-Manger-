package com.example.taskmanger.auth.screens.signup

import androidx.compose.ui.semantics.Role

data class SignUpStates (
    val email : String = "",
    val password : String ="",
    val role : Roles = Roles.STAFF,
    val phone : String = "",
)

sealed class SignUpEvents{
    data class  onEmailChange (val email : String): SignUpEvents()
    data class  onPassWordChange (val password : String): SignUpEvents()
    data class  onRoleChange (val role : Roles): SignUpEvents()
    data class  onPhoneChange (val phone : String): SignUpEvents()
}
