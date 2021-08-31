package com.aashiq.kotlin_arch_ash.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.load
import coil.request.Disposable
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.aashiq.kotlin_arch_ash.R
import com.aashiq.kotlin_arch_ash.databinding.ActivityMainBinding
import com.aashiq.kotlin_arch_ash.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding
    private var imageUrl: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()

        _binding.imgRefresh.setOnClickListener {
            fetchResponse()
        }
        _binding.imgDownload.setOnClickListener {

        }


    }


    private fun fetchResponse() {
        mainViewModel.fetchDogResponse()
        _binding.pbDog.visibility = View.VISIBLE
    }


    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        imageUrl = response.data.message
                        _binding.imgDog.load(
                            response.data.message
                        ) {
                            transformations(RoundedCornersTransformation(16f))
                        }
                    }
                    _binding.pbDog.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    _binding.pbDog.visibility = View.GONE
                    Toast.makeText(
                        this,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    _binding.pbDog.visibility = View.VISIBLE
                }
            }
        }
    }





}