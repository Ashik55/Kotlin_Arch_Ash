package com.aashiq.kotlin_arch_ash.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aashiq.kotlin_arch_ash.data.local.MySharedPreferences
import com.aashiq.kotlin_arch_ash.databinding.ActivityMainBinding
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import com.aashiq.kotlin_arch_ash.ui.paging_customer.PagingFragment
import com.aashiq.kotlin_arch_ash.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var imageUrl: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchData()

        MySharedPreferences.setToken("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNGVkYWQxNDljYjNhMmZjYTBhNjFhYzY3NmU2MWUyOWQ1NTlhODQ4M2I0NDliMjlkNDg0ZTJhNTI5NjViNWRlNjJjNmM5MDAyYzQzZGY1MWYiLCJpYXQiOjE2Mjk4NzYwODIuNzI4NTIzLCJuYmYiOjE2Mjk4NzYwODIuNzI4NTI1LCJleHAiOjE2NjE0MTIwODIuNzI0OTg1LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.FcL2YT3FwH7yj1iIOE8eh522ibywjbE3b3LC892nZI02Yn0biAmhmqMyO8CFvuOaH7BICriGaarbss3pI-ridrxJ2R5mzrImWYkWLrQJxDLNkt-8JshY2Q2LAL66TMyys-fcF7eNBAV63CF-1s8FIot2K44_fy5X0EWfclhz6uAsIFR2xoXw9mzcCfFAs3ESRm7hGtBNeWjBtC3w3VyWBhxrYNUdfDdcZVFuFUFFpE3Q5oL_R8bhTeeSJYvnfByEPzpmfWqGrtC3F5UWDvaw0xIpcyzOPLpj_i36suJMu0T7dCqCsjPuwzYpePmSSpv47L4KZsMEha2s1oxa85EpveaD_XNJvRFR6Re_Nog-1J9vYoaR3SBI69MJz7HJsI6byampE7ngJnFlJ_6nwQZuYwj0oN5lv0iZieMi8PYrxcmqQm0XCelSl-L8xTBl7TLAGSR5DVANzvR7Xs51heJMpBdZ3uYiNYy58vD31khAWe1zWnt7ZsR_Eg3uQ7cqQ544i3a2AHJtn8fzSEYkjtQzdsGMBL6HybD9eRBJL64QtN2lVAfPuM5QXBWrHypEty_tqPS0PT19jV3idwkRlWtLba2fWZrAtvBJKpm_FNp7fVoyKXWjnDkeC8JK6xkwR8fzx2IRYhRifdLKdSOBK1e9SJ4wbsUf0EH0Lk7mRa8AbVM")


        binding.customerList.setOnClickListener {
            PagingFragment().show(
                supportFragmentManager,
                "signature"
            )
        }
    }


    private fun fetchResponse() {
        mainViewModel.fetchCustomerList()
        binding.progressBar.visibility = View.VISIBLE
    }


    private fun fetchData() {
        fetchResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {

//                        _binding.customerRV.adapter = CustomerAdapter(
//                            it.data?.customers?.data,
//                            object : CustomerAdapter.clickListener {
//                                override fun onItemClick(currentItem: CustomersResponse.Data.Customers.Data?) {
//
//                                }
//                            })


//                        imageUrl = response.data.message
//                        _binding.imgDog.load(
//                            response.data.message
//                        ) {
//                            transformations(RoundedCornersTransformation(16f))
//                        }


                    }
                    binding.progressBar.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }


}