package com.shyampanchal.lendify.base

import androidx.lifecycle.ViewModel
import com.shyampanchal.lendify.di.DaggerViewModelInjector
import com.shyampanchal.lendify.di.NetworkModule
import com.shyampanchal.lendify.di.ViewModelInjector
import com.shyampanchal.lendify.viewmodels.HomeViewModel
import com.shyampanchal.lendify.viewmodels.RegisterViewModel

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
            is RegisterViewModel -> injector.inject(this)
        }
    }
}