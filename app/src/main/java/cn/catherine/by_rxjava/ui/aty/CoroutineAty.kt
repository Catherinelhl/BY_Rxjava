package cn.catherine.by_rxjava.ui.aty

import android.graphics.BitmapFactory
import android.os.Bundle
import cn.catherine.by_rxjava.R
import cn.catherine.by_rxjava.common.BaseAty
import cn.catherine.by_rxjava.coroutine.basic.onStartCoroutine
import cn.catherine.by_rxjava.coroutine.basic.startLoadingData
import kotlinx.android.synthetic.main.aty_coroutine.*
import rx.Observable

/**
 * Created by catherine on 2018/3/18.
 */
const val LOGO_URL = "http://www.imooc.com/static/img/index/logo.png?t=1.1"

class CoroutineAty : BaseAty() {
    override fun getArgs(bundle: Bundle?) {
    }

    override fun setView(): Int = R.layout.aty_coroutine
    override fun initViews() {
    }

    override fun setListener() {
        btn_verification.setOnClickListener {
            println("${Thread.currentThread()}-我要开始协程了！")
            onStartCoroutine {
                val imageData = startLoadingData(LOGO_URL)
                println("${Thread.currentThread()}-数据拿回来了：$imageData")
                iv_bg.setImageBitmap(BitmapFactory.decodeByteArray(imageData, 0, imageData.size))
            }
            println("${Thread.currentThread()}-协程执行完毕了！")
        }
    }

}