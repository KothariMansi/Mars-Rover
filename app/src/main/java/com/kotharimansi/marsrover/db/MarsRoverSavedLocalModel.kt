package com.kotharimansi.marsrover.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rover_photo")
data class MarsRoverSavedLocalModel(

    @PrimaryKey
    @ColumnInfo(name = "rover_photo_id")
    @SerializedName("rover_photo_id")
    val roverPhotoId: Int,

    @ColumnInfo(name = "rover_name")
    @SerializedName("rover_photo")
    val roverName: String = "",

    @ColumnInfo(name = "img_src")
    @SerializedName("imgSrc")
    val imgSrc: String = "",

    @ColumnInfo(name = "sol")
    @SerializedName("sol")
    val sol: String = "",

    @ColumnInfo(name = "earth_date")
    @SerializedName("earth_date")
    val earthDate: String = "",

    @ColumnInfo(name = "camera_full_name")
    @SerializedName("camera_full_name")
    val cameraFullName: String = ""
)