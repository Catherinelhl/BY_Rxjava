package cn.catherine.by_rxjava.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by catherine on 2018/3/12.
 */
abstract class BaseAty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getArgs(intent.extras)
        setContentView(setView())
        initViews()
        setListener()
    }

    abstract fun getArgs(bundle: Bundle?)
    abstract fun setView(): Int
    abstract fun initViews()
    abstract fun setListener()

}