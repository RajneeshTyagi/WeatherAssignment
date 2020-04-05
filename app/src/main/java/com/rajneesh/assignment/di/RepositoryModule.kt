package com.rajneesh.assignment.di

import android.util.Log
import com.health.ness.repository.ApiServices
import com.health.ness.repository.RepositoryCalls
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RepositoryModule {
    val BASE_UEL = "http://api.weatherstack.com/"
    private var mHttpLoggingInterceptor: HttpLoggingInterceptor? = null

    @Singleton
    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        if (mHttpLoggingInterceptor == null) {
            mHttpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                    Log.d("OkHttp :- ", message)
                })
            mHttpLoggingInterceptor!!.level = HttpLoggingInterceptor.Level.BODY
        }
        return mHttpLoggingInterceptor!!
    }

    @Singleton
    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getHttpLoggingInterceptor())
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()


    }

    @Singleton
    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_UEL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    @Singleton
    private fun provideApiServices() = getRetrofitInstance().create(ApiServices::class.java)

    @Provides
    fun getRepositoryCalls() = RepositoryCalls(provideApiServices())
}