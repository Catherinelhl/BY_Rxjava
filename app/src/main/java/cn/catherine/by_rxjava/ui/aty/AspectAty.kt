package cn.catherine.by_rxjava.ui.aty

import android.os.Bundle
import cn.catherine.by_rxjava.R
import cn.catherine.by_rxjava.common.BaseAty
import kotlinx.android.synthetic.main.aty_aspect.*

/**
 * Created by catherine on 2018/3/21.
 * 用于验证AspectJ
 */
class AspectAty : BaseAty() {
    override fun getArgs(bundle: Bundle?) {
    }

    override fun setView(): Int = R.layout.aty_aspect

    override fun initViews() {
    }

    override fun setListener() {
        btn_aspect.setOnClickListener { println("this is a test.") }
    }
}