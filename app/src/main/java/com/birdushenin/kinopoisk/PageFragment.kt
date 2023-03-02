package com.birdushenin.kinopoisk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.birdushenin.kinopoisk.databinding.FragmentPageBinding


class PageFragment : Fragment() {
    private val viewModel: ViewModel by activityViewModels()

    private lateinit var adapter: FilmItemAdapter
    private lateinit var b: FragmentPageBinding
    private val filmItemsList: MutableList<FilmItem> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)

        b = FragmentPageBinding.bind(view)

        populateList()
        setUpAdapter()

        b.newFragment.setOnClickListener{
            val newFragment = ListFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    private fun setUpAdapter() {
        adapter = FilmItemAdapter(this.requireContext(),
            viewModel.filmItemsList as MutableList<FilmItem>
        )
        b.newFragment.adapter = adapter
        b.newFragment.layoutManager = LinearLayoutManager(this.requireContext())
    }

    private fun populateList() {
        for (i in 1..15) {
            val name = "Film Item $i"
            val year = (100 * i).toString()
            val filmItem = FilmItem(name = name, year = year)
            filmItemsList.add(filmItem)
        }
    }
}