package cn.catherine.by_rxjava.ui.aty

import android.os.Bundle
import android.os.Message
import cn.catherine.by_rxjava.R
import cn.catherine.by_rxjava.aspect.annotations.DebugLog
import cn.catherine.by_rxjava.common.BaseAty
import cn.catherine.by_rxjava.tools.L
import cn.catherine.by_rxjava.tools.print
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
        btn_aspect.setOnClickListener {
            //            this.print(suffix = "dot to btn_aspect")
            printArgs()
//            printArgs("")
//            printArgs("", 1)
//            printArgs(1, "", "")
        }
    }

    @DebugLog
    private fun printArgs() {
        L.i("debuglog noparameters")
    }

    @DebugLog
    private fun printArgs(parameters: String) {
        L.i("debuglog parameter 1")
    }

    @DebugLog
    private fun printArgs(parameters: String, code: Int) {
        L.i("debuglog parameter 2")
    }

    @DebugLog
    private fun printArgs(code: Int, parameters: String, message: String) {
        L.i("debuglog parameter 3")
    }

}