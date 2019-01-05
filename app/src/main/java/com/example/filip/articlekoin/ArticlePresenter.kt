package com.example.filip.articlekoin

import io.reactivex.Observable
import io.reactivex.Scheduler
import org.funktionale.option.getOrElse

class ArticlePresenter(articleDao: ArticleDao,
                       uiScheduler: Scheduler,
                       articleId: Int,
                       clickObservable: Observable<Unit>) {

    val articleObservable: Observable<String> = clickObservable
            .switchMap {
                articleDao.articleObservable(articleId)
                        .observeOn(uiScheduler)
                        .subscribeOn(uiScheduler)
            }
            .map { it.fold({ it.message().getOrElse { "" } }, { it.article.title }) }
}