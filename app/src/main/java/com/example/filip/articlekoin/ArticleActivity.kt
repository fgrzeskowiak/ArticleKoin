package com.example.filip.articlekoin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.clicks
import empty
import io.reactivex.disposables.SerialDisposable
import kotlinx.android.synthetic.main.activity_article.*
import org.funktionale.option.getOrElse
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.core.parameter.parametersOf

class ArticleActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ARTICLE_ID = "extra_article_id"
        fun newIntent(context: Context, articleId: Int) = Intent(context, ArticleActivity::class.java)
                .putExtra(EXTRA_ARTICLE_ID, articleId)
    }

    private val presenter: ArticlePresenter by inject { parametersOf(intent.getIntExtra(EXTRA_ARTICLE_ID, 123), simple_button.clicks().share()) }
    private val disposable = SerialDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        bindScope(getOrCreateScope("article"))

        disposable.set(
                presenter.articleObservable
                        .subscribe {
                            article_title.text = it
                        }
        )
    }

    override fun onDestroy() {
        disposable.empty()
        super.onDestroy()
    }
}
