package com.example.filip.articlekoin

import com.example.filip.articlekoin.models.ArticleResponse
import io.reactivex.Observable
import io.reactivex.Scheduler
import org.funktionale.either.Either
import toEither

class ArticleDao(articleService: ArticleService,
                 networkScheduler: Scheduler) {

    val articleObservable: (Int) -> Observable<Either<DefaultError, ArticleResponse>> = { articleId ->
        articleService.getArticle(articleId)
                .subscribeOn(networkScheduler)
                .toObservable()
                .toEither()
                .replay(1)
                .refCount()
    }
}