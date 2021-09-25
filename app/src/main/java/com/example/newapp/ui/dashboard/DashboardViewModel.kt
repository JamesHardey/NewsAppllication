package com.example.newapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapp.models.moviereview.MovieReview
import com.example.newapp.models.moviereview.Result
import com.example.newapp.models.topstory.TopStory
import com.example.newapp.repository.MovieReviewRepository
import kotlinx.coroutines.launch

class DashboardViewModel(private val movieReviewRepository: MovieReviewRepository) : ViewModel() {

    private val _movieReviews = MutableLiveData<List<Result>>()

    val movieReviews: LiveData<List<Result>> = _movieReviews

    fun getMovieReview(){
        viewModelScope.launch {
            _movieReviews.value = movieReviewRepository.getMovieReviews()
        }
    }

}