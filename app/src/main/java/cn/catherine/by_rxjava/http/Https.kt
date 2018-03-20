package cn.catherine.by_rxjava.http

/**
 * Created by catherine on 2018/3/18.
 */
object HttpError {
    const val HTTP_ERROR_NO_DATA = 999
    const val HTTP_ERROR_UNKNOWN = 998
    const val HTTP_ERROR = 997
}

data class HttpException(val code: Int) : Exception()