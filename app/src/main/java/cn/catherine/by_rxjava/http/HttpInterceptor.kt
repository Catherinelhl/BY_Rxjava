package cn.catherine.by_rxjava.http

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by catherine on 2018/3/12.
 */
class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val map: MutableMap<String, String> = mutableMapOf()
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader("Accept-Language",
                "zh-CN")

        builder.url(request.url().toString())
        println(builder)
        map.forEach { (k, v) ->
            builder.addHeader(k, v)
        }
        println(chain.proceed(builder.build()))
        return chain.proceed(builder.build())
    }
}