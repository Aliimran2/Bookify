package com.mias.bookify.models

import com.mias.bookify.adapters.LAYOUT_HOME


data class HomeModel(
    val catTitle : String? = null,
    val bookList: ArrayList<BooksModel>? = null,
    val bod : BooksModel? = null,
    val LAYOUT_TYPE : Int = LAYOUT_HOME
)
