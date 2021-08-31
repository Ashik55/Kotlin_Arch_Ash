package com.aashiq.kotlin_arch_ash.di

import android.util.Log
import com.aashiq.kotlin_arch_ash.data.local.MySharedPreferences
import com.aashiq.kotlin_arch_ash.data.remote.ApiService
import com.aashiq.kotlin_arch_ash.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor{ chain ->

                val authorization = MySharedPreferences.getToken()
                Log.d("Authorization", "" + authorization)
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", authorization ?: "")
                    .build()
                val response = chain.proceed(newRequest)
                if (response.code == 401) {
                    //Signout user
                    return@addInterceptor response
                }
                return@addInterceptor response
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
         GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideCurrencyService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}