package id.ac.ui.cs.mobileprogramming.movielore.ui.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import id.ac.ui.cs.mobileprogramming.movielore.R
import id.ac.ui.cs.mobileprogramming.movielore.data.model.FavoriteMovie
import id.ac.ui.cs.mobileprogramming.movielore.databinding.ItemMovieBinding

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private lateinit var list : List<FavoriteMovie>

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovieList(list: List<FavoriteMovie>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteMovie: FavoriteMovie) {
            with(binding) {

                Glide.with(itemView)
                    .load("${favoriteMovie.baseUrl}${favoriteMovie.poster_path}")
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(ivMoviePoster)
                tvMovieTitle.text = favoriteMovie.original_title
                binding.root.setOnClickListener { onItemClickCallback?.onItemClick(favoriteMovie) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        Log.e("adapter", "Masukan bind dan view holder")
        holder.bind(list[position])
    }

    interface OnItemClickCallback {
        fun onItemClick(favoriteMovie: FavoriteMovie)
    }
}