package com.mias.bookify

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.mias.bookify.databinding.LayoutHomeBinding

const val BOOK_IMAGE = "book_image"
const val BOOK_TITLE = "book_title"
const val BOOK_DESCRIPTION = "book_description"
const val BOOK_PDF = "book_pdf"

class BooksAdapter(private val list: ArrayList<BooksModel>, private val context: Context) :
    RecyclerView.Adapter<BooksAdapter.BooksVH>() {






    class BooksVH(val binding: LayoutHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        return BooksVH(
            LayoutHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BooksVH, position: Int) {

        val model = list[position]
        holder.binding.apply {
            bookImageView.setImageResource(model.image)
            root.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(BOOK_IMAGE, model.image)
                intent.putExtra(BOOK_TITLE, model.title)
                intent.putExtra(BOOK_DESCRIPTION, model.description)
                intent.putExtra(BOOK_PDF, model.bookPDF)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity,bookImageView, "bookTrans")
                context.startActivity(intent, options.toBundle())
            }

        }

    }
}