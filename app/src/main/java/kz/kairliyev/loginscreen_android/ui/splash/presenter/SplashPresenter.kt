package kz.kairliyev.loginscreen_android.ui.splash.presenter

import kz.kairliyev.loginscreen_android.ui.base.presenter.BasePresenter
import kz.kairliyev.loginscreen_android.ui.splash.interactor.SplashAppInteractor
import kz.kairliyev.loginscreen_android.ui.splash.view.SplashAppView
import kz.kairliyev.loginscreen_android.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter<V : SplashAppView, I : SplashAppInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), SplashAppPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        decideActivityToOpen()
    }

    private fun decideActivityToOpen() = getView()?.let {
        if (isUserLoggedIn())
            it.openMainActivity()
        else
            it.openLoginActivity()
    }

    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }

}