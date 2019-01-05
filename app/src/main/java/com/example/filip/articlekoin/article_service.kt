package com.example.filip.articlekoin

import com.example.filip.articlekoin.models.ArticleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {
    @GET("api/articles/{id}")
    fun getArticle(@Path("id") id: Int): Single<ArticleResponse>
}