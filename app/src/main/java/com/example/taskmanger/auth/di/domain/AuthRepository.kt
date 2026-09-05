package com.example.taskmanger.auth.di.domain

interface AuthRepository {

    suspend fun signIn (email  : String , password : String  ) : Result<Unit>
    suspend fun signOut() : Result<Unit>

}