package com.example.exlistview

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface INetworkAPI {
    @GET("recipes.json")

    fun getAlldata(): Observable<List<food>>
}