package cn.catherine.by_rxjava.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

/**
 * Created by catherine on 2018/3/21.
 *
 * 这里会分成几个部分，我们依次来看：

@Before：Advice，也就是具体的插入点
execution：处理Join Point的类型，例如call、execution
(* android.app.Activity.on**(..))：这个是最重要的表达式，第一个『*』表示返回值，
『*』表示返回值为任意类型，后面这个就是典型的包名路径，其中可以包含『*』来进行通配，
几个『*』没区别。同时，这里可以通过『&&、||、!』来进行条件组合。()代表这个方法的参数，
你可以指定类型，例如android.os.Bundle，或者(..)这样来代表任意类型、任意个数的参数。
public void onActivityMethodBefore：实际切入的代码。
 */

@Aspect
class AspectU {
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