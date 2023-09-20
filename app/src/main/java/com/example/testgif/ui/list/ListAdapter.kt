package com.example.testgif.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testgif.data.model.Gif
import com.example.testgif.databinding.ItemGifBinding
import com.example.testgif.ui.util.GlideProvider.setGif

class ListAdapter(private val gifListener: GifListener) :
    RecyclerView.Adapter<ListAdapter.GifViewHolder>() {

    private var gifs: List<Gif> = emptyList()

    fun setGifs(gifs: List<Gif>) {
        this.gifs = gifs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val binding = ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifViewHolder(binding)
    }

    override fun getItemCount(): Int = gifs.size

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(gifs[position])
    }

    inner class GifViewHolder(private val binding: ItemGifBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gif: Gif) {
            val url = gif.images.downsized.url
            binding.ivGifHolder.setGif(url)
            binding.ivGifHolder.setOnClickListener {
                gifListener.navigateToGif(url)
            }
        }
    }
}