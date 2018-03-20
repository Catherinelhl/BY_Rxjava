package cn.catherine.by_rxjava.model

import cn.catherine.by_rxjava.http.HttpApi
import cn.catherine.by_rxjava.http.RetrofitFactory
import cn.catherine.by_rxjava.http.Server
import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by catherine on 2018/3/12.
 */
class MainInterceptor {

    fun ping(): Observable<String> {
        val httpApi = RetrofitFactory[Server.PING].create(HttpApi::class.java)
        return httpApi.ping()
    }
    fun testCoroutine(): Observable<ResponseBody> {
        val httpApi = RetrofitFactory[Server.PING].create(HttpApi::class.java)
        return httpApi.testCoroutine()
    }
}