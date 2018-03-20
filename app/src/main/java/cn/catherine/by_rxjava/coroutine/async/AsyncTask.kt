package cn.catherine.by_rxjava.coroutine.async

import java.util.concurrent.Executors

/**
 * Created by catherine on 2018/3/18.
 * 实现异步协程
 */
private val pool by lazy { Executors.newCachedThreadPool() }

class AsyncTask(private val block: () -> Unit) {
 fun execute()= pool.execute(block)
}