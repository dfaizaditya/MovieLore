package id.ac.ui.cs.mobileprogramming.movielore.data

import androidx.paging.PagingSource
import id.ac.ui.cs.mobileprogramming.movielore.api.MovieApi
import id.ac.ui.cs.mobileprogramming.movielore.data.model.Movie
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource (
    private val movieApi: MovieApi
): PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {


        return try {
            val pos = params.key ?: STARTING_PAGE_INDEX
            val response = movieApi.getNowPlayingMovies(pos)
            val movies = response.results

            LoadResult.Page(
                data = movies,
                prevKey = if (pos == STARTING_PAGE_INDEX) null else pos-1,
                nextKey = if (movies.isEmpty()) null else pos+1
            )
        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException){
            LoadResult.Error(e)
        }

    }
}