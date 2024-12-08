package com.mias.bookify

object DataProvider {

    val list : ArrayList<BooksModel> = ArrayList()

    init {
        list.add(BooksModel(R.drawable.book_1, "Speed Math", "Tricks and Tips", "speed_math.pdf"))
        list.add(BooksModel(R.drawable.book_2, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_3, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_4, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_5, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_6, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_7, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_8, "Book Title", "Book Description", "sample_book.pdf"))
        list.add(BooksModel(R.drawable.book_9, "Book Title", "Book Description", "sample_book.pdf"))
    }
}