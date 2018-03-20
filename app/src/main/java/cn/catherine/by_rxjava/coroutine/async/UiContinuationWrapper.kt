package cn.catherine.by_rxjava.coroutine.async

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by catherine on 2018/3/18.
 */
class UiContinuationWrapper<in T>(private val continuation: Continuation<T>) : Continuation<T> {
    override val context: CoroutineContext = continuation.context
    override fun resume(value: T) {
        //切换线程
        continuation.resume(value)
    }

    override fun resumeWithException(exception: Throwable) {
        //切换线程
        continuation.resumeWithException(exception)
    }
}