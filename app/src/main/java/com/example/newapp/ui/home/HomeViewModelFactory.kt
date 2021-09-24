package com.example.newapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.repository.TopStoryRepository

class HomeViewModelFactory(private val repository: TopStoryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        else {
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }

}