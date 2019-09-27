package kz.kairliyev.loginscreen_android.ui.splash.presenter

import kz.kairliyev.loginscreen_android.ui.base.presenter.AppPresenter
import kz.kairliyev.loginscreen_android.ui.splash.interactor.SplashAppInteractor
import kz.kairliyev.loginscreen_android.ui.splash.view.SplashAppView

interface SplashAppPresenter<V : SplashAppView, I : SplashAppInteractor> : AppPresenter<V,I>