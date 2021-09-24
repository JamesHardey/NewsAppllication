package com.example.newapp.models.moviereview

data class MovieReview(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)