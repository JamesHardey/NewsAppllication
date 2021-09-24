package com.example.newapp.ui.webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newapp.R
import com.example.newapp.databinding.FragmentArticleBinding
import com.example.newapp.databinding.FragmentHomeBinding
import com.example.newapp.ui.home.HomeViewModel


class ArticleFragment : Fragment() {

    private lateinit var articleWebViewModel: ArticleWebViewModel
    private var _binding: FragmentArticleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articleWebViewModel =
            ViewModelProvider(this).get(ArticleWebViewModel::class.java)

        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val root: View = binding.root


        articleWebViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}