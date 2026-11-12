package com.example.taskmanger.manger.data

import com.example.taskmanger.models.UserProfile

interface UserRemoteDataSource {


    suspend fun createUser(user: UserProfile)

    suspend fun getUser(id: String): UserProfile?


}