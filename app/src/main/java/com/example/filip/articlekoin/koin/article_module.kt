package com.example.filip.articlekoin.koin

import com.example.filip.articlekoin.ArticleDao
import com.example.filip.articlekoin.ArticlePresenter
import io.reactivex.Observable
import org.koin.dsl.module.module

val articleModule = module {
    single { ArticleDao(get(), get("networkScheduler")) }
    scope("article") { (articleId: Int, clickObservable: Observable<Unit>) -> ArticlePresenter(get(), get("uiScheduler"), articleId, clickObservable) }
}