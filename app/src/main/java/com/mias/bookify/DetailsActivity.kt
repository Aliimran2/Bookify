package com.mias.bookify

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mias.bookify.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val image = intent.getIntExtra(BOOK_IMAGE, 0)
        val title = intent.getStringExtra(BOOK_TITLE)
        val desc = intent.getStringExtra(BOOK_DESCRIPTION)
        val bookPdf = intent.getStringExtra(BOOK_PDF)

        binding.apply {
            bookImageView.setImageResource(image)
            titleTextView.text = title
            descTextView.text = desc
            readBookButton.setOnClickListener {
                val intent = Intent(this@DetailsActivity, PdfActivity::class.java)
                intent.putExtra(BOOK_PDF, bookPdf)
                startActivity(intent)

            }

        }


    }
}