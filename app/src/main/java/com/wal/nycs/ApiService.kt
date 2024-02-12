package com.wal.nycs

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("resource/s3k6-pzi2.json")
    suspend fun getData(): Response<List<Data>>
}