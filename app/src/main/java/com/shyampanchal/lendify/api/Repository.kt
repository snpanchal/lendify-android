package com.shyampanchal.lendify.api

class Repository(private val itemsApi: ItemsApi) {

    fun getAllItems() = itemsApi.getAllItems()
}