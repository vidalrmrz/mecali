package com.vr.data.network

import com.vr.data.dtos.BaseResponse
import com.vr.data.dtos.ItemDetailDto
import com.vr.data.dtos.ItemDto
import com.vr.data.dtos.ScoreDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApi {

    @GET("sites/MCO/search")
    fun getItems(@Query("q") query: String): Single<BaseResponse<ItemDto>>

    @GET("reviews/item/{id}")
    fun getItemScore(@Path("id") id: String): Single<ScoreDto>

    @GET("/items/{id}")
    fun getItemDetail(@Path("id") id: String): Single<ItemDetailDto>
}