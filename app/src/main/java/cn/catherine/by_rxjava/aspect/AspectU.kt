package cn.catherine.by_rxjava.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before



@Aspect
class AspectU {
    private val TAG = "aspect log-"

    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.initViews**(..))")
    fun onActivityMethodBefore(joinPoint: JoinPoint) {
        try {
            val key = joinPoint.signature.toString()
            println("$TAG onActivityMethodBefore +$key")
        } catch (e: Exception) {
            println("catch the exception :$e")

        }
    }
}