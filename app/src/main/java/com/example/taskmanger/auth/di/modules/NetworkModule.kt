package com.example.taskmanger.auth.di.modules

import com.example.taskmanger.auth.data.AuthRemoteDataSource
import com.example.taskmanger.auth.data.AuthRemoteDataSourceImpl
import com.example.taskmanger.auth.network.createHttpClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return createHttpClient()
    }
}




//@Module
//@InstallIn(SingletonComponent::class)
//abstract class NetworkModule {
//        @Binds
//        abstract fun bindAuthDataSource(
//            impl: AuthRemoteDataSourceImpl
//        ): AuthRemoteDataSource
//    }


