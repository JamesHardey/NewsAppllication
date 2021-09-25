package com.example.newapp.repository

import com.example.newapp.R
import com.example.newapp.api.ApiService

class TopStoryRepository(private val apiService: ApiService){

    private val key:String = "WSnW0iIkuNFrg1BUAUNQmH9XpiBHFsrg"

    suspend fun getTopStory(section:String) = apiService.getTopStory(section,key).results

}