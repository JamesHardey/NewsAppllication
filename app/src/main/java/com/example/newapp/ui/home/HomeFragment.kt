package com.example.newapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.R
import com.example.newapp.api.Api
import com.example.newapp.databinding.FragmentHomeBinding
import com.example.newapp.repository.TopStoryRepository

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by lazy{
        ViewModelProvider(this, HomeViewModelFactory(TopStoryRepository(Api.apiService)))
            .get(HomeViewModel::class.java)
    }

    private lateinit var adapter: TopStoryViewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        adapter = TopStoryViewAdapter()
        binding.recycler.adapter = adapter

        homeViewModel.getTopStory()

        homeViewModel.topStory.observe(viewLifecycleOwner, Observer {
            adapter.add(it)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}