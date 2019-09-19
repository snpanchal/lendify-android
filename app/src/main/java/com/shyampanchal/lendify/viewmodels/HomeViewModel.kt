package com.shyampanchal.lendify.viewmodels

import androidx.lifecycle.MutableLiveData
import com.shyampanchal.lendify.api.ApiService
import com.shyampanchal.lendify.base.BaseViewModel
import com.shyampanchal.lendify.models.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    @Inject lateinit var apiService: ApiService

    private lateinit var disposable: Disposable

    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val itemsList: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        loadItems()
    }

    private fun loadItems() {
        disposable = apiService.getAllItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { itemsList.value = it },
                { errorMessage.value = it.message }
            )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}