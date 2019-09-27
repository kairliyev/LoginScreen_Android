package kz.kairliyev.loginscreen_android.ui.base.presenter

import kz.kairliyev.loginscreen_android.ui.base.interactor.AppInteractor
import kz.kairliyev.loginscreen_android.ui.base.view.AppView


interface  AppPresenter<V : AppView, I : AppInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}