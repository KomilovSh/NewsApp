package com.example.news

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.news.db.ArticleDao
import com.example.news.models.NewsResponse
import com.example.news.network.Constants
import com.example.news.repository.Repository
import com.example.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var newsResponse: NewsResponse
    lateinit var viewModel: NewsViewModel
    lateinit var repository: Repository
    lateinit var articleDao: ArticleDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.fetchNews("us", Constants.API_KEY)
        newsResponse = viewModel.getNewsResponse()
        Log.d(TAG, "onCreate: $newsResponse")
    }
}