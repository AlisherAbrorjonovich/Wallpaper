package com.example.navigationview1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationview1.R
import com.example.navigationview1.utils.GridSpacingItemDecoration
import com.example.navigationview1.utils.ImageModel

class ViewPagerAdapter(
    private val imageLists: List<List<ImageModel>>,
    private val onImageClick: (Int) -> Unit
) : RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.page_recycler_view, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val images = imageLists[position] // Sahifaga mos rasm ro'yxati
        val adapter = ImageAdapter(images, onImageClick)

        // GridLayoutManager bilan uchta ustunli qilib sozlash
        holder.recyclerView.layoutManager = GridLayoutManager(
            holder.itemView.context,
            3 // Bir qatorda uchta element
        )
        holder.recyclerView.adapter = adapter

        // Rasmlar orasida masofa qo'shish (ixtiyoriy)
        if (holder.recyclerView.itemDecorationCount == 0) { // Oldin qo'shilmagan bo'lsa
            holder.recyclerView.addItemDecoration(GridSpacingItemDecoration(3, 16))
        }
    }

    override fun getItemCount() = imageLists.size
}