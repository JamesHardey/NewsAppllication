package com.example.newapp.api

import androidx.lifecycle.LiveData
import com.example.newapp.models.moviereview.MovieReview
import com.example.newapp.models.topstory.TopStory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private  val BASE_URL ="https://api.nytimes.com/svc/"

interface ApiService {

    @GET("topstories/v2/home.json")
    suspend fun getTopStory(): LiveData<List<TopStory>>

    @GET("/reviews/picks.json")
    suspend fun getMovieReviews(): LiveData<List<MovieReview>>


}

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    object Api{
        val apiService: ApiService by lazy{
            retrofit.create(ApiService::class.java)
        }

}