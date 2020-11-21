package id.ac.ui.cs.mobileprogramming.movielore.data

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.movielore.data.model.FavoriteMovie
import id.ac.ui.cs.mobileprogramming.movielore.data.dao.FavoriteMovieDao

@Database(
    entities = [FavoriteMovie::class],
    version = 1
)
abstract class FavoriteMovieDatabase : RoomDatabase(){
    abstract fun getFavoriteMovieDao(): FavoriteMovieDao
}