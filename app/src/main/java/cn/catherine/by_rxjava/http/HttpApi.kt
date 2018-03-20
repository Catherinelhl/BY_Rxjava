package cn.catherine.by_rxjava.http

import okhttp3.ResponseBody
import retrofit2.http.GET
import rx.Observable

/**
 * Created by catherine on 2018/3/12.
 */
interface HttpApi {

    @GET("ping")
    fun ping(): Observable<String>

//    @GET("https://t12.baidu.com/it/u=733274681,461725225&fm=173&app=12&f=JPEG?w=440&h=346&s=60A0D45D4E65B44D40AAB5AD0300C00A")
//    @GET("http://macdown.uranusjr.com/static/images/logo-160.png")
    @GET("http://www.imooc.com/static/img/index/logo.png?t=1.1")
    fun testCoroutine(): Observable<ResponseBody>

}