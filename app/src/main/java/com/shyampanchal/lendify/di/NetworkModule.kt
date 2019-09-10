package com.shyampanchal.lendify.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.shyampanchal.lendify.api.ItemsApi
import com.shyampanchal.lendify.utils.UrlManager
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() =
            Retrofit.Builder()
                .baseUrl(UrlManager.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

    @Provides
    @Singleton
    fun getItemsApi(retrofit: Retrofit) = retrofit.create(ItemsApi::class.java)
}