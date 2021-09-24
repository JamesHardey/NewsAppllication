package com.example.newapp.repository

import com.example.newapp.R
import com.example.newapp.api.ApiService

class TopStoryRepository(private val apiService: ApiService){

    val key:String = "WSnW0iIkuNFrg1BUAUNQmH9XpiBHFsrg"

    suspend fun getTopStory() = apiService.getTopStory(key).results

}