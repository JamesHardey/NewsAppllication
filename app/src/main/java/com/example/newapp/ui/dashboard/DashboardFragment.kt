package com.example.newapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.api.Api
import com.example.newapp.databinding.FragmentDashboardBinding
import com.example.newapp.repository.MovieReviewRepository

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val dashboardViewModel: DashboardViewModel by lazy{
        ViewModelProvider(this, MovieReviewsViewModelFactory(MovieReviewRepository(Api.apiService)))
            .get(DashboardViewModel::class.java)
    }

    private lateinit var adapter: MovieReviewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieReviewAdapter()
        binding.movieReviewRecycler.adapter = adapter



        dashboardViewModel.movieReviews.observe(viewLifecycleOwner, Observer {
            adapter.add(it)
        })

        dashboardViewModel.getMovieReview()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}