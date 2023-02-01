package com.example.tfl.di

import com.example.tfl.data.TubeLinesApi
import com.example.tfl.data.repo.TubeLineRepositoryImpl
import com.example.tfl.domain.repo.TubeLineRepository
import com.example.tfl.util.Constants.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

//    @Provides
//    @Singleton
//    fun providesApiRequest(): TubeLinesApi {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(
//                OkHttpClient.Builder()
//                    .addInterceptor(HttpLoggingInterceptor().apply {
//                        level = HttpLoggingInterceptor.Level.BASIC
//                    }).build()
//            )
//            .build()
//            .create(TubeLinesApi::class.java)
//    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun providesShowsApi(retrofit: Retrofit): TubeLinesApi = retrofit.create(TubeLinesApi::class.java)

    @Provides
    @Singleton
    fun providesTubeLineRepository(tubeLinesApi: TubeLinesApi) : TubeLineRepository{
        return TubeLineRepositoryImpl(tubeLinesApi)
    }
}