package kz.kairliyev.loginscreen_android.ui.login

import kz.kairliyev.loginscreen_android.ui.login.interactor.LoginInteractor
import kz.kairliyev.loginscreen_android.ui.login.interactor.LoginAppInteractor
import kz.kairliyev.loginscreen_android.ui.login.presenter.LoginAppPresenter
import kz.kairliyev.loginscreen_android.ui.login.presenter.LoginPresenter
import kz.kairliyev.loginscreen_android.ui.login.view.LoginAppView
import dagger.Module
import dagger.Provides


@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginAppInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginAppView, LoginAppInteractor>)
            : LoginAppPresenter<LoginAppView, LoginAppInteractor> = presenter

}