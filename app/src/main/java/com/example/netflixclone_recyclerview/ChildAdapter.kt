package com.example.netflixclone_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter (private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder?>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        // Here we inflate the corresponding layout of the child item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {
        // Create an instance of the ChildItem class for the given position
        val childItem = childItemList[position]

        // For the created instance, set image.
        childViewHolder.childItemImage.setImageResource(childItem.childItemImage)
    }

    // This method returns the number of items we have added in the ChildItemList
    // i.e. the number of instances of the ChildItemList that have been created
    override fun getItemCount(): Int = childItemList.size

    // This class is to initialize the Views present the child RecyclerView
    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var childItemImage: ImageView
        init {
            childItemImage = itemView.findViewById<ImageView>(
                R.id.img_child_item
            )
        }
    }
}