package com.sf.dcd.compose.core.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.sf.dcd.compose.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideClientInterceptor(
        @ApplicationContext context: Context
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        return okHttpClient
            .addInterceptor(ChuckerInterceptor(context))
            .connectTimeout(180L, TimeUnit.SECONDS)
            .writeTimeout(180L, TimeUnit.SECONDS)
            .readTimeout(180L, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(clientInterceptor: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(clientInterceptor)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}