package com.elninoqd.basearchitecture.data.api

import com.elninoqd.basearchitecture.data.model.Repo
import com.elninoqd.basearchitecture.data.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    companion object {
        private const val API_URL = "https://api.github.com"
        private val apiInterface: ApiService? = null
        fun getApiService(): ApiService {
            if (apiInterface != null) {
                return apiInterface
            }
            val retrofit = Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String): Call<User>

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") userId: String): Call<List<Repo>>
}