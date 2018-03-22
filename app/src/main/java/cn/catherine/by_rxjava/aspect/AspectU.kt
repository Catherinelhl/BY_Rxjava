package cn.catherine.by_rxjava.aspect

import cn.catherine.by_rxjava.tools.L
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class AspectU {


    //@Pointcut("within(@cn.catherine.by_rxjava.aspect.annotations.DebugLog *)")//待研究
//  @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..,java.lang.String))")//接受最后一个参数是String类型的，切且其前边可以接受有任意人参数的方法
//    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(java.lang.String,..))")//接受第一个参数是String类型开始，且其前后可以接受有任意人参数的方法
    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..))")
    fun pointCut() {
    }

    //    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
//@Around("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.**(..))")
    fun onActivityMethodBefore(joinPoint: JoinPoint) = try {
        val key = joinPoint.signature.toString()
        L.i("onActivityMethodBefore :$key")
    } catch (e: Exception) {
        L.i("catch the exception :$e")

    }


    @Before("pointCut()")
    fun debugLog(joinPoint: JoinPoint) = try {
        val key = joinPoint.signature.toString()
        L.i("debugLog :$key")
    } catch (e: Exception) {
        L.i("catch the exception :$e")

    }


}