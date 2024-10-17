package com.example.m16_arch.di

import com.example.m16_arch.data.BoredApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)  // Указываем, что модуль будет доступен на уровне Singleton (всего приложения)
object NetworkModule {

    //Предоставляем экземпляр Retrofit
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bored.api.lewagon.com/api/activity/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Предоставляем экземпляр BoredApiService, используя Retrofit
    @Provides
    @Singleton
    fun provideBoredApiService(retrofit: Retrofit): BoredApiService {
        return retrofit.create(BoredApiService::class.java)
    }
}