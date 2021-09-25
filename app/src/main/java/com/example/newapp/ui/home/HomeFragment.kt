package com.example.newapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newapp.R
import com.example.newapp.api.Api
import com.example.newapp.databinding.FragmentHomeBinding
import com.example.newapp.repository.TopStoryRepository

class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener{

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by lazy{
        ViewModelProvider(this, HomeViewModelFactory(TopStoryRepository(Api.apiService)))
            .get(HomeViewModel::class.java)
    }

    private lateinit var adapter: TopStoryViewAdapter

    private val items = listOf(
            "Arts", "Automobiles", "Books", "Business", "Fashion",
        "Food", "Health", "Home", "Insider", "Magazine", "Movies",
        "New-york Region", "Obituaries", "Opinion", "Politics",
        "Real Estate", "Science", "Sports", "Sunday Review",
        "Technology", "Theater", "T-Magazine", "Travel",
        "Upshot", "US", "World"
    )


    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var itemList: AutoCompleteTextView
    private var value = 7

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TopStoryViewAdapter()
        binding.recycler.adapter = adapter

        swipeRefreshLayout = binding.swipeRefresh
        swipeRefreshLayout.setOnRefreshListener(this)

        val dropDownAdapter = ArrayAdapter(requireContext(), R.layout.item_list_section, items)

        itemList = binding.dropdownField
        itemList.setAdapter(dropDownAdapter)

        itemList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                getData(position)
        }

        itemList.setText(dropDownAdapter.getItem(7).toString(),false)

        homeViewModel.topStory.observe(viewLifecycleOwner, Observer {
            adapter.add(it)
        })

        homeViewModel.isReloadingData.observe(viewLifecycleOwner) { isLoading ->
            swipeRefreshLayout.isRefreshing = isLoading
        }

        getData(value)

    }

    override fun onRefresh() {
        getData(value)
    }

    private fun getData(value: Int){
        homeViewModel.retrieveDate(value)
    }

}