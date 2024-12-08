package com.mias.bookify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mias.bookify.databinding.ActivityPdfBinding

class PdfActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPdfBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        val pdfBook = intent.getStringExtra(BOOK_PDF) ?: "sample_book.pdf"


        binding.apply {
            pdfView.fromAsset(pdfBook)
                .enableSwipe(true)
                .enableDoubletap(true)
                .swipeVertical(true)

                .load()
        }
    }

}
