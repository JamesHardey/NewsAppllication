package com.example.newapp.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.repository.MovieReviewRepository
import com.example.newapp.repository.TopStoryRepository
import com.example.newapp.ui.home.HomeViewModel

class MovieReviewsViewModelFactory(private val repository: MovieReviewRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DashboardViewModel::class.java)){
            return DashboardViewModel(repository) as T
        }
        else {
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}