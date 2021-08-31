package com.aashiq.kotlin_arch_ash.ui.main

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aashiq.kotlin_arch_ash.data.Repository
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import com.aashiq.kotlin_arch_ash.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<CustomersResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<CustomersResponse>> = _response


    fun fetchCustomerList() = viewModelScope.launch {
        repository.getDog().collect { values ->

            println(values)

            _response.value = values
        }
    }


//    fun downloadImage(bitmap: Bitmap, dir: File, fileName: String) {
//
//        viewModelScope.launch {
//            repository.saveImage(bitmap, dir, fileName).collect { value ->
//                _downloadResponse.value = value
//            }
//        }
//    }




}