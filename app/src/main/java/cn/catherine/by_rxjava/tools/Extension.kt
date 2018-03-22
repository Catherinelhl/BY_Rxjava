package cn.catherine.by_rxjava.tools

/**
 * Created by catherine on 2018/3/22.
 */

fun Any.print() {
    if (this == "") {
        L.i("parameters is null")
    } else {
        L.i(this.toString())
    }
}

fun Any.print(prefix: String = "", suffix: String) {
    if (this == "") {
        L.i("parameters is null")
    } else {
        L.i("$prefix [${this}] : $suffix")
    }
}
