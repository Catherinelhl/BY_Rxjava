package cn.catherine.by_rxjava.http

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by catherine on 2018/3/12.
 */
object RetrofitFactory {
    private var okHttpClient: OkHttpClient? = null
    private val retrofitMap: MutableMap<Server, Retrofit> = mutableMapOf()
    operator fun get(server: Server): Retrofit {
        return retrofitMap[server]!!
    }

    fun add(server: Server, retrofit: Retrofit) {
        retrofitMap[server] = retrofit
    }

    private fun Retrofit.Builder.prepare(baseUrl: String, client: OkHttpClient): Retrofit {
        return this.baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(StringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    init {
        val httpInterceptor = HttpInterceptor()
        if (okHttpClient == null) {
            okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(httpInterceptor)
                    .build()
        }
        add(Server.PING, Retrofit.Builder().prepare("https://api.boxfish.cn/", okHttpClient!!))
        add(Server.BASE_API, Retrofit.Builder().prepare("https://api.boxfish.cn/", okHttpClient!!))

    }

}