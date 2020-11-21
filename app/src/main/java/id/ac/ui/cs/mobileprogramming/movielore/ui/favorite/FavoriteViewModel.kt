package id.ac.ui.cs.mobileprogramming.movielore.ui.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.movielore.data.model.FavoriteMovie
import id.ac.ui.cs.mobileprogramming.movielore.data.FavoriteMovieRepository


class FavoriteViewModel @ViewModelInject constructor(
    private val repository: FavoriteMovieRepository
) : ViewModel(){
    val movies = repository.getFavoriteMovies()
}