package cn.catherine.by_rxjava.aspect.annotations

import kotlin.annotation.Target

/**
 * Created by catherine on 2018/3/21.
 */

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR)
annotation class DebugLog