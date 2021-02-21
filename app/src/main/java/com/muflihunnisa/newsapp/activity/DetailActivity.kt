package com.muflihunnisa.newsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muflihunnisa.newsapp.R

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NEWS = "extra_news"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
    }
}