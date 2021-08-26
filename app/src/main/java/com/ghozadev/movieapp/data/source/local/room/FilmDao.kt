package com.ghozadev.movieapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM movieEntities")
    fun getListMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowEntities")
    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movieEntities WHERE isFavorite = 1")
    fun getListFavoriteMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowEntities WHERE isFavorite = 1")
    fun getListFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movieEntities WHERE movieId = :movieId")
    fun getDetailMovieById(movieId: Int) : LiveData<MovieEntity>

    @Query("SELECT * FROM tvShowEntities WHERE tvShowId = :tvShowId")
    fun getDetailTvShowById(tvShowId: Int) : LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovies(movies: List<MovieEntity>)

    @Update(entity = MovieEntity::class)
    fun updateMovie(movie : MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update(entity = TvShowEntity::class)
    fun updateTvShow(tvShows: TvShowEntity)
}