package com.shyampanchal.lendify.injection.component

import com.shyampanchal.lendify.di.NetworkModule
import com.shyampanchal.lendify.viewmodels.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects required dependencies into specified [HomeViewModel]
     */
    fun inject(homeViewModel: HomeViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}