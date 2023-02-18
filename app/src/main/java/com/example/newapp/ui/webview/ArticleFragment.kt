package com.example.newapp.ui.webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.newapp.R
import com.example.newapp.databinding.FragmentArticleBinding
import com.example.newapp.databinding.FragmentHomeBinding
import com.example.newapp.ui.home.HomeViewModel


class ArticleFragment : Fragment() {

    private lateinit var articleWebViewModel: ArticleWebViewModel
    private lateinit var binding: FragmentArticleBinding
    private lateinit var link: String
    private lateinit var webView: WebView

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        link = arguments?.getString("link")!!
        articleWebViewModel =
            ViewModelProvider(this).get(ArticleWebViewModel::class.java)

        binding = FragmentArticleBinding.inflate(inflater, container, false)


        articleWebViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = binding.webView
        webView.loadUrl(link)
        webView.settings.javaScriptEnabled = true
    }



}