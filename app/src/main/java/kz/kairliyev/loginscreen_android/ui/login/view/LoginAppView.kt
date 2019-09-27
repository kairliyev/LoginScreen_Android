package kz.kairliyev.loginscreen_android.ui.login.view

import kz.kairliyev.loginscreen_android.ui.base.view.AppView


interface LoginAppView : AppView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}