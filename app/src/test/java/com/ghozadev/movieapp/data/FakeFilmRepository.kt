package com.ghozadev.movieapp.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.source.local.LocalDataSource
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.remote.ApiResponse
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import com.ghozadev.movieapp.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FakeFilmRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ) : FilmDataSource {

    override fun getPopularMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>() {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getPopularMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        null,
                        response.id,
                        response.title,
                        response.posterPath,
                        response.releaseDate,
                        response.description,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        localDataSource.getDetailMovie(movieId)

    override fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>() {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getPopularTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        null,
                        response.id,
                        response.title,
                        response.posterPath,
                        response.releaseDate,
                        response.description,
                        false
                    )
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShows(tvShowList)
            }

        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        localDataSource.getDetailTvShow(tvShowId)

    override fun setFavoriteMovie(movie: MovieEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteMovie(movie)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteTvShow(tvShow)
        }
    }

}