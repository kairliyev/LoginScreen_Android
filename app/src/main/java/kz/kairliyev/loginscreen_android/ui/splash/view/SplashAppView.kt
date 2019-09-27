package kz.kairliyev.loginscreen_android.ui.splash.view

import kz.kairliyev.loginscreen_android.ui.base.view.AppView


interface SplashAppView : AppView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
}