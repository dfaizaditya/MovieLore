package id.ac.ui.cs.mobileprogramming.movielore.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.movielore.data.MovieRepository

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository) : ViewModel(){
    val movies = repository.getNowPlayingMovies()
}