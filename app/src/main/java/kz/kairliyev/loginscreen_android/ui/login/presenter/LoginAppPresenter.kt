package kz.kairliyev.loginscreen_android.ui.login.presenter

import kz.kairliyev.loginscreen_android.ui.base.presenter.AppPresenter
import kz.kairliyev.loginscreen_android.ui.login.interactor.LoginAppInteractor
import kz.kairliyev.loginscreen_android.ui.login.view.LoginAppView


interface LoginAppPresenter<V : LoginAppView, I : LoginAppInteractor> : AppPresenter<V, I> {

    fun onServerLoginClicked(email: String, password: String)

}