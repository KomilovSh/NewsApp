package com.example.news.networkimport com.example.news.models.NewsResponseimport io.reactivex.Observableimport retrofit2.http.GETimport retrofit2.http.Queryinterface RetrofitService {    @GET("top-headlines")    fun getNews(        @Query("country") country: String,        @Query("apiKey") apiKey: String    ): Observable<NewsResponse>}