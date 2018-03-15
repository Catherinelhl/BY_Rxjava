package cn.catherine.by_rxjava.presenter

import cn.catherine.by_rxjava.common.BasePresenter
import cn.catherine.by_rxjava.model.MainInterceptor
import retrofit2.adapter.rxjava.HttpException
import rx.subscriptions.CompositeSubscription

/**
 * Created by catherine on 2018/3/12.
 */
class MainPresenter : BasePresenter() {

    private val compositeSubscription by lazy { CompositeSubscription() }
    fun pingInteract() {
        var subscription = MainInterceptor().ping()
                .compose(transformerIo())
                .doOnError {
                    if (it is HttpException) {
                        println("doOnError ->HttpException:$it")
                    } else {
                        println("doOnError $it")

                    }

                }.subscribe(
                        {
                            println("success ")
                        },
                        {
                            if (it is HttpException) {
                                println("exception ->HttpException:$it")

                            } else {
                                println("exception $it")

                            }

                        })
        compositeSubscription.add(subscription)
    }
}