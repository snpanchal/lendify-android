package com.shyampanchal.lendify.viewmodels

import androidx.lifecycle.MutableLiveData
import com.shyampanchal.lendify.R
import com.shyampanchal.lendify.api.ItemsApi
import com.shyampanchal.lendify.base.BaseViewModel
import com.shyampanchal.lendify.models.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    @Inject lateinit var itemsApi: ItemsApi

    private lateinit var disposable: Disposable

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val itemsList: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        loadItems()
    }

    private fun loadItems() {
        disposable = itemsApi.getAllItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { itemsList.value = it },
                { errorMessage.value = R.string.post_error }
            )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}