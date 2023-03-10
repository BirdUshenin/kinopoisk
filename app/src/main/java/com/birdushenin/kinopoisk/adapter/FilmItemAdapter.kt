package com.birdushenin.kinopoisk.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.kinopoisk.databinding.FilmItemLayoutBinding

class FilmItemAdapter(private val context: Context, private val filmItemList:MutableList<FilmItem>)
    : RecyclerView.Adapter<FilmItemAdapter.FilmItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
            val binding = FilmItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

            return FilmItemViewHolder(binding)
        }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int){
        val filmItem = filmItemList[position]
        holder.bind(filmItem)
    }

    override fun getItemCount(): Int {
        return filmItemList.size
    }

    class FilmItemViewHolder(private val filmItemLayoutBinding: FilmItemLayoutBinding)
        : RecyclerView.ViewHolder(filmItemLayoutBinding.root){

        @SuppressLint("SetTextI18n")
        fun bind(filmItem: FilmItem){
            filmItemLayoutBinding.nameFilm.text = filmItem.name
            filmItemLayoutBinding.yearFilm.text = "Rs. ${filmItem.year}"
        }
        }
    }
