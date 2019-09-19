package com.shyampanchal.lendify.viewmodels

import android.util.Log
import com.shyampanchal.lendify.api.ApiService
import com.shyampanchal.lendify.base.BaseViewModel
import com.shyampanchal.lendify.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterViewModel : BaseViewModel() {

    @Inject lateinit var apiService: ApiService
    private lateinit var disposable: Disposable

    fun addNewUser(user: User) {
        disposable = apiService.addUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { Log.i("PostUser", it.toString()) }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}