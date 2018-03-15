package cn.catherine.by_rxjava.http

import retrofit2.http.GET
import rx.Observable

/**
 * Created by catherine on 2018/3/12.
 */
interface HttpApi {

    @GET("ping")
    fun ping(): Observable<String>

}