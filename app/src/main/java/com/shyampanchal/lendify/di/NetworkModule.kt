package com.shyampanchal.lendify.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.shyampanchal.lendify.api.ItemsApi
import com.shyampanchal.lendify.utils.UrlManager
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    internal fun provideRetrofit() =
            Retrofit.Builder()
                .baseUrl(UrlManager.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

    @Provides
    @Reusable
    fun provideItemsApi(retrofit: Retrofit) = retrofit.create(ItemsApi::class.java)
}