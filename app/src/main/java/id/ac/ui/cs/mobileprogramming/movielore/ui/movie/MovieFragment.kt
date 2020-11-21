package id.ac.ui.cs.mobileprogramming.movielore.ui.movie

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import id.ac.ui.cs.mobileprogramming.movielore.R
import id.ac.ui.cs.mobileprogramming.movielore.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.paging.LoadState
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.movielore.data.model.Movie


@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnItemClickListener{

    private val viewModel by viewModels<MovieViewModel>()
    private var _binding : FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMovieBinding.bind(view)

        val adapter = MovieAdapter(this)

        binding.apply {
            rvMovie.setHasFixedSize(true)
            rvMovie.adapter = adapter.withLoadStateHeaderAndFooter(
                    header = MovieLoadStateAdapter {adapter.retry()},
                    footer = MovieLoadStateAdapter {adapter.retry()}
            )
            btnTryAgain.setOnClickListener {
                adapter.retry()
            }
        }

        viewModel.movies.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        adapter.addLoadStateListener { loadState ->
            binding.apply {
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                rvMovie.isVisible = loadState.source.refresh is LoadState.NotLoading
                btnTryAgain.isVisible =loadState.source.refresh is LoadState.Error
                tvFailed.isVisible = loadState.source.refresh is LoadState.Error

                //not found
                if (loadState.source.refresh is LoadState.NotLoading &&
                        loadState.append.endOfPaginationReached &&
                        adapter.itemCount < 1){
                    rvMovie.isVisible = false
                    tvNotFound.isVisible = true
                } else {
                    tvNotFound.isVisible = false
                }
            }
        }

        setHasOptionsMenu(true)
    }

    override fun onItemClick(movie: Movie) {
        val action = MovieFragmentDirections.actionNavMovieToNavDetails(movie)
        findNavController().navigate(action)
    }


}