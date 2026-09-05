package com.example.taskmanger.auth.data.repository

import android.util.Log
import com.example.taskmanger.auth.data.AuthRemoteDataSource
import com.example.taskmanger.auth.di.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signIn(email: String, password: String)  : Result<Unit>{
    return     try {
        val request = authRemoteDataSource.signIn(email,password)
        if (request.isSuccess){
            Log.e("Logged In  ","Heeeeeeey")
            Result.success(Unit)
        }else{
            Result.failure(Throwable(request.exceptionOrNull()))
        }

        }catch (e : Exception){
             Result.failure(e)

        }

    }

    override suspend fun signOut(): Result<Unit> {
    return    try {
             val request = authRemoteDataSource.signOut()
            if (request.isSuccess){
                Result.success(Unit)
            }else{
                Result.failure(Throwable(request.exceptionOrNull()))
            }
        }catch (e : Throwable){
        Result.failure(e)
        }
    }
}