package com.mias.bookify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mias.bookify.databinding.ItemBodBinding
import com.mias.bookify.databinding.ItemBookBinding
import com.mias.bookify.models.BooksModel
import com.mias.bookify.utils.loadOnline

class HomeChildAdapter(val list : ArrayList<BooksModel>, val context: Context):RecyclerView.Adapter<HomeChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: BooksModel, context: Context){
            binding.apply {
                model.apply {
                  mBookImgView.loadOnline(image)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ChildViewHolder(ItemBookBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val currentBook = list[position]
        holder.bind(currentBook, context )
    }
}