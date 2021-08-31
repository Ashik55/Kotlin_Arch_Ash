package com.aashiq.kotlin_arch_ash.data.remote

import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/customers")
    suspend fun getCustomers(): Response<CustomersResponse>

}
