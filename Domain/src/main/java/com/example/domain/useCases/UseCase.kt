package com.example.domain.useCases

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.from
import jdk.internal.util.Preconditions
import java.util.concurrent.Executor

abstract class UseCase<T,Params> {
    lateinit var executor: Executor
    abstract fun buildUseCaseObservable(params:Params):Observable<T>
    fun execute(observer:DisposableObserver<T>,params:Params){
//        val observable:Observable<T> = this.buildUseCaseObservable(params).subscribeOn(Scheduler.from(executor))
    }
}