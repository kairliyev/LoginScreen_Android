package kz.kairliyev.loginscreen_android.ui.splash

import kz.kairliyev.loginscreen_android.ui.splash.interactor.SplashInteractor
import kz.kairliyev.loginscreen_android.ui.splash.interactor.SplashAppInteractor
import kz.kairliyev.loginscreen_android.ui.splash.presenter.SplashAppPresenter
import kz.kairliyev.loginscreen_android.ui.splash.presenter.SplashPresenter
import kz.kairliyev.loginscreen_android.ui.splash.view.SplashAppView
import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashAppInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashAppView, SplashAppInteractor>)
            : SplashAppPresenter<SplashAppView, SplashAppInteractor> = splashPresenter
}