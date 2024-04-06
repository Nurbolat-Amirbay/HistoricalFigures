package kz.ayala.historicalfiguresapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {
    @Headers("X-Api-Key:6T5BW8ynEd+Ccl0RNUdr2Q==IdjU5aSE0JidsCrJ")
    @GET("historicalfigures")
    fun getHistFiguresByName(@Query("name") name: String): Call<List<HistFigure>>
}