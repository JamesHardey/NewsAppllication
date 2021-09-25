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

    private val _isReloadingData = MutableLiveData<Boolean>()
    val isReloadingData:LiveData<Boolean> get() = _isReloadingData

    private val firstSection = "arts"

    private val sectionItem = listOf(
        "arts", "automobiles", "books", "business", "fashion",
        "food", "health", "home", "insider", "magazine",
        "movies", "nyregion", "obituaries", "opinion",
        "politics", "realestate", "science", "sports",
        "sundayreview", "technology", "theater", "t-magazine",
        "travel", "upshot", "us","world"
    )

    private fun getTopStory(section: String){
        viewModelScope.launch {
            _isReloadingData.value = true
            try{
                _topStories.value = repository.getTopStory()
            }
            catch (ex:Exception){

            }

            _isReloadingData.value = false

        }
    }

    fun retrieveDate(value: Int){
        getTopStory(sectionItem[value])
    }

}