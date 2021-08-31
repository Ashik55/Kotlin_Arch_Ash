package com.aashiq.kotlin_arch_ash.ui.paging_customer

import android.app.Application
import androidx.lifecycle.*
import com.aashiq.kotlin_arch_ash.data.Repository
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import com.aashiq.kotlin_arch_ash.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PagingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _response: MutableLiveData<NetworkResult<CustomersResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<CustomersResponse>> = _response


    fun fetchCustomerList() = viewModelScope.launch {
        repository.getDog().collect { values ->

            println(values)

            _response.value = values
        }
    }


}