package com.shyampanchal.lendify.viewmodels

import androidx.lifecycle.ViewModel
import com.shyampanchal.lendify.api.Repository
import androidx.lifecycle.MutableLiveData
import com.shyampanchal.lendify.models.Item
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel : ViewModel() {

    private lateinit var repository: Repository
    private val disposables = CompositeDisposable()
    private val responseLiveData = MutableLiveData<List<Item>>()

}