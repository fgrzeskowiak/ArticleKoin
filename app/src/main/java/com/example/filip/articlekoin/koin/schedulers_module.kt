package com.example.filip.articlekoin.koin

import com.example.filip.articlekoin.SchedulerProvider
import com.example.filip.articlekoin.SchedulerProviderImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

val schedulersModule = module {
    single { SchedulerProviderImpl() as SchedulerProvider }
}

val schedulersModuleNamed = module {
    single("uiScheduler") { AndroidSchedulers.mainThread() }
    single("networkScheduler") { Schedulers.io() }
    single("computationScheduler") { Schedulers.computation() }
}