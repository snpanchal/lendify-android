package com.shyampanchal.lendify.api

import android.database.Observable
import com.shyampanchal.lendify.models.Item
import com.shyampanchal.lendify.utils.UrlManager
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ItemsApi {

    @GET(UrlManager.itemsUrl)
    fun getAllItems() : Deferred<Response<List<Item>>>
}