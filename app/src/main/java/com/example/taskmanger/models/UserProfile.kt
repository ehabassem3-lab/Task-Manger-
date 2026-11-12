package com.example.taskmanger.models


import com.google.firebase.Timestamp

data class UserProfile(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = UserRole.EMPLOYEE.name,
    val createdAt: Timestamp? = null
)
