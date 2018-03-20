package cn.catherine.by_rxjava.coroutine.basic

import cn.catherine.by_rxjava.coroutine.BaseContinuation
import cn.catherine.by_rxjava.coroutine.async.AsyncTask
import cn.catherine.by_rxjava.coroutine.async.UiContinuationWrapper
import cn.catherine.by_rxjava.http.HttpError
import cn.catherine.by_rxjava.http.HttpException
import cn.catherine.by_rxjava.model.MainInterceptor
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine
import retrofit2.adapter.rxjava.HttpException as rxjavaHttpException

/**
 * Created by catherine on 2018/3/18.
 */
fun onStartCoroutine(block: suspend () -> Unit) {
    block.startCoroutine(BaseContinuation())
}

suspend fun startLoadingData(url: String) = suspendCoroutine<ByteArray> { continuation ->
    println("耗时操作，下载图片")
    val uiContinuation = UiContinuationWrapper(continuation)
    AsyncTask {
        try {
            MainInterceptor().testCoroutine()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        println("${Thread.currentThread()}-下载成功！$it")
                        it?.byteStream()?.readBytes()?.let {
                            { value: ByteArray ->
                                uiContinuation.resume(value)
                            }
                        }
                    }, {
                        if (it is rxjavaHttpException) {
                            println("${Thread.currentThread()}-服务器异常：$it")
                            uiContinuation.resumeWithException(HttpException(it.code()))
                        } else {
                            println("${Thread.currentThread()}-下载失败：$it")
                            uiContinuation.resumeWithException(HttpException(HttpError.HTTP_ERROR_UNKNOWN))
                        }
                    })
        } catch (e: Exception) {
            println("${Thread.currentThread()}-拦截到异常$e")
            uiContinuation.resumeWithException(HttpException(HttpError.HTTP_ERROR_UNKNOWN))

        }

    }.execute()

    println("${Thread.currentThread()}-加载数据完毕！")



}