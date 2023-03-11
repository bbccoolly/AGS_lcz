package com.ags.lcz.core.network.di

import com.ags.lcz.core.network.BuildConfig
import com.ags.lcz.core.network.interceptor.HttpRequestInterceptor
import com.ags.lcz.core.network.service.*
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
//    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    private const val BASE_URL = "https://www.wanandroid.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(HttpRequestInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                } else {
                    setLevel(HttpLoggingInterceptor.Level.NONE)
                }
            })
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
    fun providePlayAndroidApiService(retrofit: Retrofit): PlayAndroidApiService {
        return retrofit.create(PlayAndroidApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePlayAndroidDexClient(playAndroidApiService: PlayAndroidApiService): PlayAndroidDexClient {
        return PlayAndroidDexClient(playAndroidApiService)
    }

    @Provides
    @Singleton
    fun provideSunFlowerApiService(retrofit: Retrofit): SunflowerApiService {
        return retrofit.create(SunflowerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSunflowerDexClient(sunflowerApiService: SunflowerApiService): SunflowerDexClient {
        return SunflowerDexClient(sunflowerApiService)
    }

    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): PokemonApiService {
        return retrofit.create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonDexClient(pokemonApiService: PokemonApiService): PokemonDexClient {
        return PokemonDexClient(pokemonApiService)
    }


}