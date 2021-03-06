package com.aashiq.kotlin_arch_ash.data.remote

import com.aashiq.kotlin_arch_ash.data.remote.DogService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val dogService: DogService) {
    suspend fun getDog() = dogService.getDog()

}