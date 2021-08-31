package com.aashiq.kotlin_arch_ash.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aashiq.kotlin_arch_ash.R
import com.aashiq.kotlin_arch_ash.model.CustomersResponse
import kotlinx.android.synthetic.main.item_contacts.view.*


class CustomerAdapter(
    val items: List<CustomersResponse.Data.Customers.Data?>?,
    var listener: clickListener
) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items?.size!!
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = items?.get(position)

        holder.itemView.image.load(currentItem?.file?.fileUrl) {
            fallback(R.drawable.ic_download)
        }

        holder.itemView.name.text = currentItem?.name
        holder.itemView.phone.text = currentItem?.phone

        holder.itemView.contacts.setOnClickListener {
            listener.onItemClick(currentItem)
        }


    }


    override fun getItemViewType(position: Int): Int {
        return position
    }


    interface clickListener {
        fun onItemClick(currentItem: CustomersResponse.Data.Customers.Data?)

    }


}

