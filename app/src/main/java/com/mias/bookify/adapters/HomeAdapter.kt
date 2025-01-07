package com.mias.bookify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mias.bookify.databinding.ItemBodBinding
import com.mias.bookify.databinding.ItemHomeBinding
import com.mias.bookify.models.BooksModel
import com.mias.bookify.models.HomeModel
import com.mias.bookify.utils.loadOnline

const val LAYOUT_HOME = 0
const val LAYOUT_BOD = 1

class HomeAdapter(
    val list: ArrayList<HomeModel>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class HomeItemViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        val mViewPool = RecyclerView.RecycledViewPool()
        fun bind(model: HomeModel, context: Context) {

            binding.apply {
                model.apply {
                    mCategoryTitle.text = catTitle
                    mSeeAllBtn.setOnClickListener {

                    }
                    if (bookList != null){
                        mChildRvBooks.setupChildRv(bookList, context)
                    }
                }

            }

        }

        private fun RecyclerView.setupChildRv(list: ArrayList<BooksModel>, context: Context){
            val adapter = HomeChildAdapter(list, context)
            this.adapter = adapter
            setRecycledViewPool(mViewPool)
        }
    }


    class BODItemViewHolder(val binding: ItemBodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel, context: Context) {
            binding.apply {
                model.bod?.apply {
                    imageView.loadOnline(image)
                    mReadBookBtn.setOnClickListener {
                        //
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = list[position]
        return if (model.LAYOUT_TYPE == LAYOUT_HOME) LAYOUT_HOME else LAYOUT_BOD
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            LAYOUT_HOME -> {
                val binding = ItemHomeBinding.inflate(inflater, parent, false)
                HomeItemViewHolder(binding)
            }

            else -> {
                val binding = ItemBodBinding.inflate(inflater, parent, false)
                BODItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val model = list[position]
        when (model.LAYOUT_TYPE) {
            LAYOUT_HOME -> {
                (holder as HomeItemViewHolder).bind(model, context)
            }

            else -> {
                (holder as BODItemViewHolder).bind(model, context)
            }
        }
    }


}







