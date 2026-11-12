package com.example.taskmanger.manger.di.modules

import com.example.taskmanger.manger.data.UserRemoteDataSource
import com.example.taskmanger.manger.data.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    @Singleton
    abstract fun bindUserRemoteDataSource(
        implementation: UserRemoteDataSourceImpl
    ): UserRemoteDataSource
}
