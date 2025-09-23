package com.kotharimansi.marsrover.service

import com.kotharimansi.marsrover.service.model.RoverManifestRemoteModel
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface MarsRoverManifestService {

    @GET("mars-photos/api/v1/manifest/{rover_name}?api_key=DEMO_KEY")
    suspend fun getMarsRoverManifest(
        @Path("rover_name") roverName: String
    ): RoverManifestRemoteModel

    companion object {
        private const val BASE_URL = "https://api.nasa.gov/"

        fun create(): MarsRoverManifestService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverManifestService::class.java)
        }
    }
}