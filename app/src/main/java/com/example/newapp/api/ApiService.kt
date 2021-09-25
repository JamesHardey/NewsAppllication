package com.example.newapp.api

import androidx.lifecycle.LiveData
import com.example.newapp.models.moviereview.MovieReview
import com.example.newapp.models.topstory.Home
import com.example.newapp.models.topstory.TopStory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private  val BASE_URL ="https://api.nytimes.com/svc/"
private val key = ""

interface ApiService {

    @GET("topstories/v2/home.json")
    suspend fun getTopStory(@Query("api-key")apiKey:String): Home

    @GET("movies/v2/reviews/picks.json")
    suspend fun getMovieReviews(@Query("api-key")apiKey:String): MovieReview


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