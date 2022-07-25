package com.example.netflixclone_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdapter internal constructor(private val itemList: List<ParentItem>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder?>() {
    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
    @NonNull
    override fun onCreateViewHolder(
        @NonNull viewGroup: ViewGroup,
        i: Int
    ): ParentViewHolder {

        // Here we inflate the corresponding
        // layout of the parent item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.parent_item,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(
        @NonNull parentViewHolder: ParentViewHolder,
        position: Int
    ) {

        // Create an instance of the ParentItem
        // class for the given position
        val parentItem = itemList[position]

        // For the created instance,
        // get the title and set it
        // as the text for the TextView
        parentViewHolder.parentItemTitle.text = parentItem.parentItemTitle

        // Create a layout manager
        // to assign a layout
        // to the RecyclerView.

        // Here we have assigned the layout
        // as LinearLayout with vertical orientation
        val layoutManager = LinearLayoutManager(
            parentViewHolder.childRecyclerView
                .context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method
        layoutManager.initialPrefetchItemCount = parentItem
            .childItemList
            .size

        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool
        val childItemAdapter = ChildAdapter(
            parentItem
                .childItemList
        )
        parentViewHolder.childRecyclerView.layoutManager = layoutManager
        parentViewHolder.childRecyclerView.adapter = childItemAdapter
        parentViewHolder.childRecyclerView
            .setRecycledViewPool(viewPool)
    }

    // This method returns the number
    // of items we have added in the
    // ParentItemList i.e. the number
    // of instances we have created
    // of the ParentItemList
    override fun getItemCount(): Int = itemList.size

    // This class is to initialize
    // the Views present in
    // the parent RecyclerView
    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val parentItemTitle: TextView
         val childRecyclerView: RecyclerView

        init {
            parentItemTitle = itemView
                .findViewById<TextView>(
                    R.id.parent_item_title
                )
            childRecyclerView = itemView
                .findViewById(
                    R.id.child_recycler_view
                )
        }
    }
}