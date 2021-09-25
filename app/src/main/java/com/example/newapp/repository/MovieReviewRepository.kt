package com.example.newapp.repository

import com.example.newapp.api.ApiService

class MovieReviewRepository(private val apiService: ApiService) {

    val key:String = "WSnW0iIkuNFrg1BUAUNQmH9XpiBHFsrg"

    suspend fun getMovieReviews() = apiService.getMovieReviews(key).results
}