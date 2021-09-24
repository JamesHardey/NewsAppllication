package com.example.newapp.models.topstory

data class Home(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<TopStory>,
    val section: String,
    val status: String
)