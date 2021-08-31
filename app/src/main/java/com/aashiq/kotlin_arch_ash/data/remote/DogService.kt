package com.aashiq.kotlin_arch_ash.data.remote

import com.aashiq.kotlin_arch_ash.model.DogResponse
import com.aashiq.kotlin_arch_ash.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}
