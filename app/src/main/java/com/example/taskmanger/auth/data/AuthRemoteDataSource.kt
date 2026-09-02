package com.example.taskmanger.auth.data

interface AuthRemoteDataSource {
    suspend fun signUp (email  : String , password : String  ) : Unit
}