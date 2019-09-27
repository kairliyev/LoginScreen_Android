package kz.kairliyev.loginscreen_android.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.kairliyev.loginscreen_android.ui.MainActivity
import kz.kairliyev.loginscreen_android.ui.login.LoginActivityModule
import kz.kairliyev.loginscreen_android.ui.login.view.LoginActivity
import kz.kairliyev.loginscreen_android.ui.splash.SplashActivityModule
import kz.kairliyev.loginscreen_android.ui.splash.view.SplashAppActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashAppActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

}