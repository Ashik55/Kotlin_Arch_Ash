package com.aashiq.kotlin_arch_ash.ui.paging_customer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleObserver
import com.aashiq.kotlin_arch_ash.R
import com.aashiq.kotlin_arch_ash.databinding.PagingFragmentBinding
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import com.aashiq.kotlin_arch_ash.ui.main.CustomerAdapter
import com.aashiq.kotlin_arch_ash.ui.main.MainViewModel
import com.aashiq.kotlin_arch_ash.utils.NetworkResult

class PagingFragment : Fragment(), LifecycleObserver {

    private val pagingViewModel by viewModels<PagingViewModel>()
    lateinit var binding: PagingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = PagingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


    private fun fetchResponse() {
        pagingViewModel.fetchCustomerList()
        binding.progressBar.visibility = View.VISIBLE
    }


    private fun fetchData() {
        fetchResponse()
        pagingViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {

                        binding.customerRV.adapter = CustomerAdapter(
                            it.data?.customers?.data,
                            object : CustomerAdapter.clickListener {
                                override fun onItemClick(currentItem: CustomersResponse.Data.Customers.Data?) {

                                }
                            })


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

                    Toast.makeText(
                        requireContext(),
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

}