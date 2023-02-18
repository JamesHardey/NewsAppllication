package com.example.newapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp.models.topstory.TopStory
import com.example.newapp.repository.MovieReviewRepository
import com.example.newapp.repository.TopStoryRepository
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(private val repository: TopStoryRepository) : ViewModel() {

    private val _topStories = MutableLiveData<List<TopStory>>()
    val topStory: LiveData<List<TopStory>> = _topStories

    private val _isReloadingData = MutableLiveData<Boolean>()
    val isReloadingData:LiveData<Boolean> get() = _isReloadingData

    private val sectionItem = listOf(
        "Arts", "Automobiles", "Books", "Business", "Fashion",
        "Food", "Health", "Home", "Insider", "Magazine", "Movies",
        "New-york Region", "Obituaries", "Opinion", "Politics",
        "Real Estate", "Science", "Sports", "Sunday Review",
        "Technology", "Theater", "T-Magazine", "Travel",
        "Upshot", "US", "World"
    )

    private val _selectedItem = MutableLiveData(7)
    val selectedItem: LiveData<Int> get() = _selectedItem


    init{
        println("View Model created...")
    }

    fun select(position: Int){
        _selectedItem.value = position
    }

    private fun getTopStory(section: String){
        viewModelScope.launch {
            _isReloadingData.value = true
            try{
                _topStories.value = repository.getTopStory(section)
            }
            catch (ex:Exception){

            }

            _isReloadingData.value = false

        }
    }

    fun retrieveDate(value: Int){
        getTopStory(sectionItem[value].lowercase(Locale.getDefault()))
    }

}