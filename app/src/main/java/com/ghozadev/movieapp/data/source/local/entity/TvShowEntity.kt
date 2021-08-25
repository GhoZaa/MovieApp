package com.ghozadev.movieapp.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tvShowEntities")
@Parcelize
data class TvShowEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Int = 0,

    @ColumnInfo(name = "title")
    var title:String? = null,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable