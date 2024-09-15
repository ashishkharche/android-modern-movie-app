package com.example.tmdbapp.repository

import com.example.tmdbapp.models.MovieResponse
import com.example.tmdbapp.network.RetrofitInstance
import com.example.tmdbapp.utils.Resource

class MovieRepository {
    private val api = RetrofitInstance.api
    private val apiKey = "TMDB_API_KEY_REMOVED" // Replace with your TMDB API key

    suspend fun getPopularMovies(page: Int): Resource<MovieResponse> {
        return try {
            val response = api.getPopularMovies(apiKey, page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }
    }
}