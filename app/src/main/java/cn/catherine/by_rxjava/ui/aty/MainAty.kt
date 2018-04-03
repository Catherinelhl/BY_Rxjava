package cn.catherine.by_rxjava.ui.aty

import android.os.Bundle
import cn.catherine.by_rxjava.R
import cn.catherine.by_rxjava.common.BaseAty
import cn.catherine.by_rxjava.coroutine.basic.onStartCoroutine
import cn.catherine.by_rxjava.coroutine.basic.startLoadingData
import cn.catherine.by_rxjava.presenter.MainPresenter
import kotlinx.android.synthetic.main.aty_main.*

class MainAty : BaseAty() {
    private val presenter by lazy { MainPresenter() }
    override fun getArgs(bundle: Bundle?) {
    }

    override fun setView(): Int = R.layout.aty_main

    override fun initViews() {

    }

    override fun setListener() {
        btn.setOnClickListener { presenter.pingInteract() }

    }

}
