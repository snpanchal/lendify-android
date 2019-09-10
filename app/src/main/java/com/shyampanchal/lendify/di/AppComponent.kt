package com.shyampanchal.lendify.di

import com.shyampanchal.lendify.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: HomeActivity)
}