package cn.catherine.by_rxjava.aspect

import cn.catherine.by_rxjava.tools.L
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class AspectU {

    private var enable: Boolean = true
    private var enableBefore: Boolean = true
    private var enableAfter: Boolean = true
    private var enableAround: Boolean = true

    //    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
//@Around("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.on**(..))")
    fun onActivityMethodBefore(joinPoint: JoinPoint) {
        if (!enableBefore) return
        try {
            val key = joinPoint.signature.toString()
            L.i("onActivityMethodBefore :$key")
        } catch (e: Exception) {
            L.i("catch the exception :$e")

        }

    }
//---------------初试pointCut--------------

    //  @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..,java.lang.String))")//接受最后一个参数是String类型的，切且其前边可以接受有任意人参数的方法
//    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(java.lang.String,..))")//接受第一个参数是String类型开始，且其前后可以接受有任意人参数的方法
    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..))")
    fun pointCutDebug() {
        //success

    }

    @Before("pointCutDebug()")
    fun debugLog(joinPoint: JoinPoint) {
        if (!enableBefore) return
        try {
            val key = joinPoint.signature.toString()
            L.i("debugLog :$key")
        } catch (e: Exception) {
            L.i("catch the exception :$e")

        }
    }

    //---------------------------------------
    //-------------------------测试Within || Withincode-----------------
    @Pointcut("within(@cn.catherine.by_rxjava.aspect.annotations.ClickEvent *)")//Within
    fun withinAnnotatedClass() {
        //testing
    }

    //调用printArgs（）方法内
    @Pointcut("withincode(* cn.catherine.by_rxjava.ui.aty.AspectAty.printArgs(..))")//Withincode
    fun withInCodeAnnotatedClass() {
    }

    //调用btnClickAfter（）的时候
    @Pointcut("call(* cn.catherine.by_rxjava.ui.aty.AspectAty.btnClickAfter(..))")//call ：切入的方法之前/之后调用
    fun callAnnotatedClass() {
    }

    //同时满足条件的时候才切入
    @Pointcut("withInCodeAnnotatedClass() && callAnnotatedClass()")
    fun withinCodeAndCall() {

    }


    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass()")
    fun methodInsideAnnotatedType() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    fun constructorInsideAnnotatedType() {
    }

    @Pointcut("pointCutDebug()|| methodInsideAnnotatedType()")
    fun method() {
    }

    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog *.new(..)) || constructorInsideAnnotatedType()")
    fun constructor() {
    }

    //    @After("constructorInsideAnnotatedType()")
    @Before("withinCodeAndCall()")
    fun beforeOnclickListener(joinPoint: JoinPoint) {
        if (!enableBefore) return
        try {
            val key = joinPoint.signature.toString()
            L.i("beforeOnclickListener :$key")
        } catch (e: Exception) {
            L.i("catch the exception :$e")

        }
    }
//-----------------------------

}