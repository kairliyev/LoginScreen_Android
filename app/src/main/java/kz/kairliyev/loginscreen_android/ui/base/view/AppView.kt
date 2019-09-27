package kz.kairliyev.loginscreen_android.ui.base.view

import kz.kairliyev.loginscreen_android.data.network.LoginResponse

interface AppView {

    fun showProgress()

    fun hideProgress()

    fun showToastHttpMessage(error: Throwable)

}