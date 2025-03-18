package com.example.kotlinknowledge.app.di

import com.example.kotlinknowledge.data.remote.mapper.RemoteErrorMapper
import com.example.kotlinknowledge.data.remote.mapper.RemoteErrorMapperImpl
import com.example.kotlinknowledge.data.repositories.AuthenticationRepositoryImpl
import com.example.kotlinknowledge.domain.repositories.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Suppress("unused", "TooManyFunctions")
@Module
@InstallIn(SingletonComponent::class)
internal interface DataInterfaceRemoteModule {
    @Binds
    @Singleton
    fun remoteErrorMapper(implRemote: RemoteErrorMapperImpl): RemoteErrorMapper

    @Binds
    @Singleton
    fun provideAuthenticationRepository(impl: AuthenticationRepositoryImpl): AuthenticationRepository

}
