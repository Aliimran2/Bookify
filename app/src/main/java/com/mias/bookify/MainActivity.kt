package com.mias.bookify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mias.bookify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val activity = this

    private val list : ArrayList<BooksModel> = DataProvider.list
    private val adapter = BooksAdapter(list, activity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            mRecyclerViewHome.adapter = adapter
        }

    }
}