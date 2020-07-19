package com.vr.data.di

import com.vr.data.BuildConfig.BASE_URL
import com.vr.data.network.SearchApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideSearchApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)