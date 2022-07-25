package com.example.netflixclone_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentRecyclerViewItem: RecyclerView = findViewById(
            R.id.parent_recyclerview
        )

        // Initialise the Linear layout manager
        val layoutManager = LinearLayoutManager(
            this@MainActivity
        )

        // Pass the arguments
        // to the parentItemAdapter.
        // These arguments are passed
        // using a method ParentItemList()
        val parentItemAdapter = ParentAdapter(
            parentItemList()
        )

        // Set the layout manager
        // and adapter for items
        // of the parent recyclerview
        parentRecyclerViewItem.adapter = parentItemAdapter
        parentRecyclerViewItem.layoutManager = layoutManager
    }

    private fun parentItemList(): List<ParentItem> {
        val itemList: MutableList<ParentItem> = ArrayList()
        val item = ParentItem(
            "My List",
            childItemMyList()
        )
        itemList.add(item)
        val item1 = ParentItem(
            "Continue watching for Chan",
            childItemContinueWatchingList()
        )
        itemList.add(item1)
        val item2 = ParentItem(
            "Popular on Netflix",
            childItemPopularList()
        )
        itemList.add(item2)
        val item3 = ParentItem(
            "Trending on Netflix",
            childItemTrendingList()
        )
        itemList.add(item3)
        val item4 = ParentItem(
            "Anime",
            childItemAnimeList()
        )
        itemList.add(item4)
        val item5 = ParentItem(
            "Casual Viewing",
            childItemCasualList()
        )
        itemList.add(item5)
        return itemList
    }

    // Method to pass the arguments for the elements of child RecyclerView
    private fun childItemMyList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img1))
        childItemList.add(ChildItem(R.drawable.img2))
        childItemList.add(ChildItem(R.drawable.img3))
        childItemList.add(ChildItem(R.drawable.img4))
        childItemList.add(ChildItem(R.drawable.img5))
        return childItemList
    }

    private fun childItemContinueWatchingList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img1))
        childItemList.add(ChildItem(R.drawable.img3))
        childItemList.add(ChildItem(R.drawable.img4))
        childItemList.add(ChildItem(R.drawable.img6))
        return childItemList
    }

    private fun childItemPopularList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img7))
        childItemList.add(ChildItem(R.drawable.img8))
        childItemList.add(ChildItem(R.drawable.img9))
        childItemList.add(ChildItem(R.drawable.img10))
        childItemList.add(ChildItem(R.drawable.img11))
        childItemList.add(ChildItem(R.drawable.img12))
        childItemList.add(ChildItem(R.drawable.img13))
        childItemList.add(ChildItem(R.drawable.img15))
        return childItemList
    }

    private fun childItemTrendingList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img17))
        childItemList.add(ChildItem(R.drawable.img18))
        childItemList.add(ChildItem(R.drawable.img13))
        childItemList.add(ChildItem(R.drawable.img16))
        childItemList.add(ChildItem(R.drawable.img7))
        childItemList.add(ChildItem(R.drawable.img6))
        childItemList.add(ChildItem(R.drawable.img8))
        childItemList.add(ChildItem(R.drawable.img19))
        return childItemList
    }

    private fun childItemAnimeList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img20))
        childItemList.add(ChildItem(R.drawable.img21))
        childItemList.add(ChildItem(R.drawable.img22))
        childItemList.add(ChildItem(R.drawable.img23))
        childItemList.add(ChildItem(R.drawable.img24))
        childItemList.add(ChildItem(R.drawable.img25))
        childItemList.add(ChildItem(R.drawable.img29))
        return childItemList
    }

    private fun childItemCasualList(): List<ChildItem> {
        val childItemList: MutableList<ChildItem> = ArrayList()
        childItemList.add(ChildItem(R.drawable.img14))
        childItemList.add(ChildItem(R.drawable.img26))
        childItemList.add(ChildItem(R.drawable.img27))
        childItemList.add(ChildItem(R.drawable.img28))
        childItemList.add(ChildItem(R.drawable.img31))
        childItemList.add(ChildItem(R.drawable.img32))
        return childItemList
    }
}