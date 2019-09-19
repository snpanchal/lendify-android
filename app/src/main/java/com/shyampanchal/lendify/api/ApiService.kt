package com.shyampanchal.lendify.api

import com.shyampanchal.lendify.models.Item
import com.shyampanchal.lendify.models.User
import com.shyampanchal.lendify.utils.UrlManager
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET(UrlManager.itemsUrl)
    fun getAllItems(): Observable<List<Item>>

    @POST(UrlManager.usersUrl)
    fun addUser(@Body user: User): Observable<Any>
}