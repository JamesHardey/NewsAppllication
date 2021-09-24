package com.example.newapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newapp.databinding.ItemArticleBinding
import com.example.newapp.models.topstory.TopStory
import com.example.newapp.repository.TopStoryRepository

class TopStoryViewAdapter : RecyclerView.Adapter<TopStoryViewAdapter.TopStoryViewHolder>() {

    private var list = listOf<TopStory>()

    inner class TopStoryViewHolder(private val binding: ItemArticleBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun bind(topStory: TopStory){
                binding.articleTitle.text = topStory.title
                binding.textView.text = topStory.abstract
                binding.articleImage.load(topStory.multimedia.last().url)
            }

    }

    fun add(topStory: List<TopStory>){
        list = topStory
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoryViewHolder {
        return TopStoryViewHolder(ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: TopStoryViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}