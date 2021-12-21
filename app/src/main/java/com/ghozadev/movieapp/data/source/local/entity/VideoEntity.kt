package com.ghozadev.movieapp.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "videoEntities")
@Parcelize
data class VideoEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "filmId")
    var filmId: Int? = 0,

    @ColumnInfo(name = "name")
    var name:String? = null,

    @ColumnInfo(name = "key")
    var key:String? = null,

    @ColumnInfo(name = "type")
    var type: String? = null
) : Parcelable
