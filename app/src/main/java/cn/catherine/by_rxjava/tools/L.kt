package cn.catherine.by_rxjava.tools

import android.util.Log


/**
 * Created by catherine on 2018/3/22.
 * 建立一个有自己思想的log类
 */
object L {
    private const val Tag = "cn.catherine.by_rxjava"
     fun i() {
        this.i("-----------")
    }

     fun i(info: String) {
        Log.i(Tag, info)
    }

}