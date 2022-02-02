package com.oguzdogdu.cocktails.data.di

import com.oguzdogdu.cocktails.data.remote.ApiService
import com.oguzdogdu.cocktails.data.repository.CocktailsRepoImpl
import com.oguzdogdu.cocktails.domain.repository.CocktailsRepoInterface
import com.oguzdogdu.cocktails.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideCocktailService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}