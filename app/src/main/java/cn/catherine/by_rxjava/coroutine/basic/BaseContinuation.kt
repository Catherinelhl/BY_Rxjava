package cn.catherine.by_rxjava.coroutine

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by catherine on 2018/3/18.
 */
class BaseContinuation : Continuation<Unit> {
    override val context: CoroutineContext = EmptyCoroutineContext
    override fun resume(value: Unit) {
        println("协程的resume数据是：$value")
    }

    override fun resumeWithException(exception: Throwable) {
        println("协程拦截的异常是：$exception")
    }
}