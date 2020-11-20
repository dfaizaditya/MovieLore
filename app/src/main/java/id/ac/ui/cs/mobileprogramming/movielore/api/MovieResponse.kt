package id.ac.ui.cs.mobileprogramming.movielore.api

import id.ac.ui.cs.mobileprogramming.movielore.data.model.Movie

data class MovieResponse(
    val results: List<Movie>
)