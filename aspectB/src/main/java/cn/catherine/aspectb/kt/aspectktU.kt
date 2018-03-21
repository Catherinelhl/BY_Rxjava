package cn.catherine.aspectb.kt

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

/**
 * Created by catherine on 2018/3/21.
 *
 * Created by catherine on 2018/3/21.
 **/
@Aspect
class aspectktU {
    private val TAG = "aspect log-"

    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.**(..))")
    fun onActivityMethodBefore(joinPoint: JoinPoint) {
        try {
            val key = joinPoint.signature.toString()
            println("$TAG onActivityMethodBefore +$key")
        } catch (e: Exception) {
            println("catch the exception :$e")

        }
    }
}