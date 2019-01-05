package com.example.filip.articlekoin

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Rx Scheduler Provider
 */
interface SchedulerProvider {
    fun network(): Scheduler
    fun ui(): Scheduler
    fun computation(): Scheduler
}

class SchedulerProviderImpl : SchedulerProvider {
    override fun network() = Schedulers.io()

    override fun ui() = AndroidSchedulers.mainThread()

    override fun computation() = Schedulers.computation()
}