package cn.catherine.by_rxjava.aspect.annotations

/**
 * Created by catherine on 2018/3/22.
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR)
annotation class ClickEvent {
}