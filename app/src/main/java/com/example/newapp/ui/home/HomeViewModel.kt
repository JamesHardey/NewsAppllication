package com.example.newapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp.models.topstory.TopStory
import com.example.newapp.repository.MovieReviewRepository
import com.example.newapp.repository.TopStoryRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: TopStoryRepository) : ViewModel() {

    private val _topStories = MutableLiveData<List<TopStory>>()

    val topStory: LiveData<List<TopStory>> = _topStories

    fun getTopStory(){
        viewModelScope.launch {
            _topStories.value = repository.getTopStory()
        }
    }

}