package com.shyampanchal.lendify.di

import com.shyampanchal.lendify.viewmodels.HomeViewModel
import com.shyampanchal.lendify.viewmodels.RegisterViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    /**
     * Injects required dependencies into specified [HomeViewModel]
     */
    fun inject(homeViewModel: HomeViewModel)

    /**
     * Injects required dependencies into specified [RegisterViewModel]
     */
    fun inject(registerViewModel: RegisterViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}