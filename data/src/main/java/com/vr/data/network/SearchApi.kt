package com.vr.data.network

import com.vr.data.dtos.BaseResponse
import com.vr.data.dtos.ItemDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search")
    fun getItems(@Query("q") query: String): Single<BaseResponse<ItemDto>>
}