package cn.catherine.by_rxjava.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut


@Aspect
class AspectU {
    private val TAG = "aspect log-"
    @Pointcut("within(@cn.catherine.by_rxjava.aspect.annotations.DebugLog *)")
    fun withinAnnotatedClass() {
    }

    @After("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.initViews**(..))||withinAnnotatedClass()")
    fun onActivityMethodBefore(joinPoint: JoinPoint) = try {
        val key = joinPoint.signature.toString()
        println("$TAG onActivityMethodBefore +$key")
    } catch (e: Exception) {
        println("catch the exception :$e")

    }


}