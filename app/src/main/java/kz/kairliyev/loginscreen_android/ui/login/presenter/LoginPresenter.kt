package kz.kairliyev.loginscreen_android.ui.login.presenter

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.kairliyev.loginscreen_android.data.network.Error
import kz.kairliyev.loginscreen_android.data.network.LoginResponse
import kz.kairliyev.loginscreen_android.ui.base.presenter.BasePresenter
import kz.kairliyev.loginscreen_android.ui.login.interactor.LoginAppInteractor
import kz.kairliyev.loginscreen_android.ui.login.view.LoginAppView
import kz.kairliyev.loginscreen_android.util.AppConstants
import kz.kairliyev.loginscreen_android.util.SchedulerProvider
import retrofit2.HttpException
import javax.inject.Inject
import retrofit2.Retrofit


class LoginPresenter<V : LoginAppView, I : LoginAppInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), LoginAppPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.doServerLoginApiCall(email, password)
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({ loginResponse ->
                        updateUserInSharedPref(
                            loginResponse = loginResponse,
                            loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER
                        )
                        getView()?.openMainActivity()
                    }, {
                        getView()?.showToastHttpMessage(it)
                    }
                    )
            }
        }
    }


    private fun updateUserInSharedPref(
        loginResponse: LoginResponse,
        loggedInMode: AppConstants.LoggedInMode
    ) =
        interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}