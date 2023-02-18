package com.example.newapp.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newapp.R
import com.example.newapp.api.Api
import com.example.newapp.databinding.FragmentHomeBinding
import com.example.newapp.models.topstory.TopStory
import com.example.newapp.repository.TopStoryRepository
import com.example.newapp.ui.webview.ArticleActivity

class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener{

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by lazy{
        ViewModelProvider(this, HomeViewModelFactory(TopStoryRepository(Api.apiService)))
            .get(HomeViewModel::class.java)
    }

    private lateinit var adapter: TopStoryViewAdapter

    private val items = arrayOf(
            "Arts", "Automobiles", "Books", "Business", "Fashion",
        "Food", "Health", "Home", "Insider", "Magazine", "Movies",
        "New-york Region", "Obituaries", "Opinion", "Politics",
        "Real Estate", "Science", "Sports", "Sunday Review",
        "Technology", "Theater", "T-Magazine", "Travel",
        "Upshot", "US", "World"
    )


    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var itemList: Spinner
    private var value = 7

    private lateinit var dropDownAdapter: ArrayAdapter<String>
    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("Home Fragment onCreateView")
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Home Fragment onViewCreated")
        adapter = TopStoryViewAdapter(){ topStory ->
            moveToArticleScreen(topStory)
        }
        binding.recycler.adapter = adapter

        swipeRefreshLayout = binding.swipeRefresh
        swipeRefreshLayout.setOnRefreshListener(this)

        itemList = binding.textInputLayout

        itemList.adapter = ArrayAdapter(
            requireActivity(),
            R.layout.item_list_section,
            items
        )

        itemList.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    homeViewModel.select(position)
//                getData(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        homeViewModel.topStory.observe(viewLifecycleOwner, Observer {
            adapter.add(it)
            adapter.notifyDataSetChanged()
        })

        homeViewModel.isReloadingData.observe(viewLifecycleOwner) { isLoading ->
            swipeRefreshLayout.isRefreshing = isLoading
        }

        homeViewModel.selectedItem.observe(viewLifecycleOwner){
            getData(it)
            value = it
        }

        println("check point 1")
        itemList.setSelection(value)

    }



    private fun getItemList(): List<String> {
        return listOf(
            "Arts", "Automobiles", "Books", "Business", "Fashion",
            "Food", "Health", "Home", "Insider", "Magazine", "Movies",
            "New-york Region", "Obituaries", "Opinion", "Politics",
            "Real " +
                    "Estate", "Science", "Sports", "Sunday Review",
            "Technology", "Theater", "T-Magazine", "Travel",
            "Upshot", "US", "World"
        )
    }


    override fun onRefresh() {
        getData(value)
    }


    private fun getData(value: Int){
        homeViewModel.retrieveDate(value)
    }


    private fun moveToArticleScreen(topStory: TopStory){
        val link = topStory.url
        findNavController().navigate(
            R.id.action_navigation_home_to_articleFragment,
            bundleOf("link" to link)
        )
        val data = Intent(requireActivity(),ArticleActivity::class.java)
        data.putExtra("link",link)
    }

}