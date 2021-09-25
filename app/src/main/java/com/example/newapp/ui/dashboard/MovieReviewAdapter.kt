package com.example.newapp.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newapp.databinding.ItemReviewBinding
import com.example.newapp.models.moviereview.Result

class MovieReviewAdapter : RecyclerView.Adapter<MovieReviewAdapter.MovieReviewViewHolder>() {

    private var list = listOf<Result>()
    private val rating = "MPAA Rating: "
    private val critics = "Critics Pick: "

    inner class MovieReviewViewHolder(private val binding: ItemReviewBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(movieReview: Result){

            binding.title.text = movieReview.display_title
            binding.textView.text = movieReview.summary_short
            binding.textView4.text = movieReview.headline
            binding.textView2.text = "$rating ${movieReview.mpaa_rating}"
            binding.textView6.text = "$critics ${movieReview.critics_pick}"
            binding.image.load(movieReview.multimedia.src)
        }

    }

    fun add(movieReviews: List<Result>){
        list = movieReviews
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReviewViewHolder {
        return MovieReviewViewHolder(
            ItemReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: MovieReviewViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}