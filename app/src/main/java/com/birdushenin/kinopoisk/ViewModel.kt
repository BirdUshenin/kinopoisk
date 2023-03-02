package com.birdushenin.kinopoisk

import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    val filmItemsList = listOf(
        FilmItem("Game of Thrones", ""),
        FilmItem("Titanic", "1997"),
        FilmItem("5 second of summer", "2014"),
        FilmItem("Spider Men", "2014"),
        FilmItem("Once day Hollywood", "2018"),
        FilmItem("With Love Rosy", "2012")
    )
}