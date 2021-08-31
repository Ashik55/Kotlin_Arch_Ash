package com.aashiq.kotlin_arch_ash.data

import com.aashiq.kotlin_arch_ash.data.remote.RemoteDataSource
import com.aashiq.kotlin_arch_ash.model.BaseApiResponse
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import com.aashiq.kotlin_arch_ash.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    BaseApiResponse() {

    suspend fun getDog(): Flow<NetworkResult<CustomersResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getCustomers() })
        }.flowOn(Dispatchers.IO)
    }





}

