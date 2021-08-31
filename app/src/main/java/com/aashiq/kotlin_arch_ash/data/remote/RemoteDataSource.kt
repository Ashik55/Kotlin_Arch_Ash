package com.aashiq.kotlin_arch_ash.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val dogService: ApiService) {
    suspend fun getCustomers() = dogService.getCustomers()

}