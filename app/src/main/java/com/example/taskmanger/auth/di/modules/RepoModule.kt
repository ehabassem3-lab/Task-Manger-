package com.example.taskmanger.auth.di.modules

import com.example.taskmanger.auth.data.repository.AuthRepositoryImpl
import com.example.taskmanger.auth.di.domain.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract  class RepoModule {

    @Binds
    @Singleton
    abstract  fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ) : AuthRepository
}