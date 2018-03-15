package cn.catherine.by_rxjava.common

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by catherine on 2018/3/15.
 */
abstract class BasePresenter {
    /*涉及到数据流时候的转换*/
    open fun <T> transformerIo(): Observable.Transformer<T, T> {
        return Observable.Transformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
    /*只是需要开启子线程的转换*/
    open fun <T> transformerNewThread(): Observable.Transformer<T, T> {
        return Observable.Transformer { observable ->
            observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}