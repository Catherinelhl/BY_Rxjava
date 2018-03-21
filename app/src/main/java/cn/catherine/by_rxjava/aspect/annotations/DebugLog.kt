package cn.catherine.by_rxjava.aspect.annotations

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Created by catherine on 2018/3/21.
 */

@Target(ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.CLASS)
annotation class DebugLog