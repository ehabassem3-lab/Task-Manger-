package com.example.taskmanger.auth.data.repository

import com.example.taskmanger.auth.data.AuthRemoteDataSource
import com.example.taskmanger.auth.di.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signIn(email: String, password: String) {
        return authRemoteDataSource.signIn(
            email = email,
            password = password
        )
    }
}