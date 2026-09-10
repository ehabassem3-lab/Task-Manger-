package com.example.taskmanger.auth.domain

interface AuthRepository {

    suspend fun signIn (email  : String , password : String  ) : Result<Unit>
    suspend fun signOut() : Result<Unit>
    suspend fun  forgetPassword(email  :  String) : Result<Unit>
    suspend fun  verifyCode(code : String) : Result<Unit>

}