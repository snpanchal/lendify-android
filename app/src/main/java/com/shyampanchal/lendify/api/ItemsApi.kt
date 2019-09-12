package com.shyampanchal.lendify.api

import com.shyampanchal.lendify.models.Item
import com.shyampanchal.lendify.utils.UrlManager
import io.reactivex.Observable
import retrofit2.http.GET

interface ItemsApi {

    @GET(UrlManager.itemsUrl)
    fun getAllItems(): Observable<List<Item>>
}