package com.shyampanchal.lendify.base

import androidx.lifecycle.ViewModel
import com.shyampanchal.lendify.di.NetworkModule
import com.shyampanchal.lendify.injection.component.DaggerViewModelInjector
import com.shyampanchal.lendify.injection.component.ViewModelInjector
import com.shyampanchal.lendify.viewmodels.HomeViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is HomeViewModel -> injector.inject(this)
        }
    }
}