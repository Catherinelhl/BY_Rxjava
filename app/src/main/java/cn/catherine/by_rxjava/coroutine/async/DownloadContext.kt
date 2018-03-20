package cn.catherine.by_rxjava.coroutine.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by catherine on 2018/3/18.
 */
class DownloadContext(val url: String) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<DownloadContext>
}