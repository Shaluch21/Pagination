package com.example.pagination

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    fun getPosts(@Query("_page") page: Int): Call<List<Post>>
}