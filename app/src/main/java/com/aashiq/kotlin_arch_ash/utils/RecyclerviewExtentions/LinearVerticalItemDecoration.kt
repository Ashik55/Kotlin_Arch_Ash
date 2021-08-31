package com.aashiq.kotlin_arch_ash.utils.RecyclerviewExtentions

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearVerticalItemDecoration(var space : Int, val topTrue:Boolean = false) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = space
        outRect.bottom = space

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space
        }


        val childCount = parent.adapter!!.itemCount
        if (parent.getChildAdapterPosition(view) == childCount-1){
            outRect.bottom = space*3

        }


        if (topTrue){
            outRect.top = space*2;
        }
    }

}