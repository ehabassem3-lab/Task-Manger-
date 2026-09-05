package com.example.taskmanger.auth.data

interface AuthRemoteDataSource {
    suspend fun signUp (email  : String , password : String  ) : Result<Unit>
    suspend fun signIn (email  : String , password : String  ) : Result<Unit>
    suspend fun signOut() : Result<Unit>


}