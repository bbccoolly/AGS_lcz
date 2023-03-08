package com.ags.lcz.core.network.di

import com.ags.lcz.core.network.interceptor.HttpRequestInterceptor
import com.ags.lcz.core.network.service.LczApiService
import com.ags.lcz.core.network.service.LczPokeDexClient
import com.ags.lcz.core.network.service.SunflowerApiDexClient
import com.ags.lcz.core.network.service.SunflowerApiService
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-02
 */
@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

//    private const val BASE_URL = "https://api.unsplash.com/"
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpRequestInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSunFlowerApiService(retrofit: Retrofit): SunflowerApiService {
        return retrofit.create(SunflowerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSunflowerApiDexClient(sunflowerApiService: SunflowerApiService): SunflowerApiDexClient {
        return SunflowerApiDexClient(sunflowerApiService)
    }

    @Provides
    @Singleton
    fun provideLczApiService(retrofit: Retrofit): LczApiService {
        return retrofit.create(LczApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokeDexClient(lczApiService: LczApiService): LczPokeDexClient {
        return LczPokeDexClient(lczApiService)
    }


}