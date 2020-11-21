package id.ac.ui.cs.mobileprogramming.movielore.di

import id.ac.ui.cs.mobileprogramming.movielore.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import android.content.Context
import androidx.room.Room
import id.ac.ui.cs.mobileprogramming.movielore.data.FavoriteMovieDatabase
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFavMovieDatabase(
            @ApplicationContext app:Context
    ) = Room.databaseBuilder(
            app,
            FavoriteMovieDatabase::class.java,
            "movie_db"
    ).build()

    @Singleton
    @Provides
    fun provideFavMovieDao(db: FavoriteMovieDatabase) = db.getFavoriteMovieDao()


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}