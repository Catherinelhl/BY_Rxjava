package cn.catherine.by_rxjava.aspect

import android.widget.Button
import cn.catherine.by_rxjava.tools.L
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class AspectU {

    private var enable: Boolean = true
    private var enableBefore: Boolean = false
    private var enableAfter: Boolean = true
    private var enableAround: Boolean = true

    //    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
//@Around("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.getArgs(android.os.Bundle))")
    @Throws(Throwable::class)
    @Before("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.on**(..))")
    fun onActivityMethodBefore(joinPoint: JoinPoint) {
        if (!enableBefore) return
        val key = joinPoint.signature.toString()
        L.i("onActivityMethodBefore :$key")

    }
//---------------初试pointCut--------------

    //  @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..,java.lang.String))")//接受最后一个参数是String类型的，切且其前边可以接受有任意人参数的方法
//    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(java.lang.String,..))")//接受第一个参数是String类型开始，且其前后可以接受有任意人参数的方法
    @Pointcut("execution(@cn.catherine.by_rxjava.aspect.annotations.DebugLog * *(..))")
    fun pointCutDebug() {
        //success

    }

    @Throws(Throwable::class)
    @Before("pointCutDebug()")
    fun debugLog(joinPoint: JoinPoint) {
        if (!enableBefore) return
        val key = joinPoint.signature.toString()
        L.i("debugLog :$key")
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
    @Throws(Throwable::class)
    @Before("withinCodeAndCall()")
    fun beforeOnclickListener(joinPoint: JoinPoint) {
        if (!enableBefore) return
        val key = joinPoint.signature.toString()//返回目标方法的签名
        L.i("beforeOnclickListener :$key")
    }
//-----------------------------
    //--------实现切入功能，然后得到回调结果------------

    //notice:当使用@Around处理时，我们需要将第一个参数定义为ProceedingJoinPoint类型，该类是JoinPoint的子类。
    @Throws(Throwable::class)
//    @Around("execution(* android.view.View.OnClickListener.on**(..))")
    @Around("execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.printArgs(..))")
    fun aroundClickListener(joinPoint: ProceedingJoinPoint): Any? {
        val args = joinPoint.args//返回目标方法的参数
        val target = joinPoint.target //返回被织入增强处理的目标对象
        L.i("@Around返回目标对象生成的代理对象：${joinPoint.`this`}")
        L.i("@Around返回被织入增强处理的目标对象：$target")
        if (args != null && args.isNotEmpty()) {
//            (args[0] as Button).text = "HAHA,i'am change"
//            L.i("@Around当前对象的值是：${args[0]}")

            val returnValue = joinPoint.proceed(args)
            L.i("@Around 被织入的目标对象为:${joinPoint.target}")
            returnValue?.let {
                L.i("@Around 被织入的目标之后:$returnValue")
                return " $returnValue,and very ugly!"
            }


        }
        return "@Around什么也没有！"
    }

    @Throws(Throwable::class)
    @AfterReturning(pointcut = "execution(* cn.catherine.by_rxjava.ui.aty.AspectAty.printArgs(..))", returning = "returnValue")
    fun log(joinPoint: JoinPoint, returnValue: Any?) {
        if (!enableBefore) return
        L.i("@AfterReturning:目标方法为${joinPoint.signature.declaringTypeName}")
        L.i("@AfterReturning:参数为${joinPoint.args}")
        L.i("@AfterReturning:返回值为：$returnValue")
        L.i("@AfterReturning:被织入的目标对象是：${joinPoint.target}")
    }


    //------------------------

}