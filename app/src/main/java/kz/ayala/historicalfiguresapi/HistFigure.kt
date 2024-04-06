package kz.ayala.historicalfiguresapi

import com.google.gson.annotations.SerializedName

data class HistFigure(
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("info") val info: HistFigureInfo
)
