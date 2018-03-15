package cn.catherine.by_rxjava.http

import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * Created by catherine on 2018/3/13.
 */
class StringConverterFactory : Converter.Factory() {
    companion object {
        private val MEDIA_TYPE = MediaType.parse("text/plain")
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?)
            : Converter<ResponseBody, *>? {
        if (String.javaClass == type) {
            return Converter<ResponseBody, String> { value ->
                println(value.string())
                value.string()
            }
        }
        return super.responseBodyConverter(type, annotations, retrofit)

    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?)
            : Converter<*, RequestBody>? {
        if (String.javaClass == type) {
            return Converter<String, RequestBody> { value -> RequestBody.create(MEDIA_TYPE, value) }

        }
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

}