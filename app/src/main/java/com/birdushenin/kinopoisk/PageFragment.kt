package com.birdushenin.kinopoisk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.birdushenin.kinopoisk.adapter.FilmItem
import com.birdushenin.kinopoisk.adapter.FilmItemAdapter
import com.birdushenin.kinopoisk.databinding.FragmentPageBinding

class PageFragment : Fragment() {
    private val viewModel: ViewModel by activityViewModels()

    private lateinit var binding: FragmentPageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)

        binding = FragmentPageBinding.bind(view)

        setUpAdapter()

        return view
    }

    private fun setUpAdapter() {

        val adapter = FilmItemAdapter(this.requireContext(),
            viewModel.filmItemsList as MutableList<FilmItem>
        )
        binding.newFragment.adapter = adapter
        binding.newFragment.layoutManager = LinearLayoutManager(this.requireContext())
    }
}