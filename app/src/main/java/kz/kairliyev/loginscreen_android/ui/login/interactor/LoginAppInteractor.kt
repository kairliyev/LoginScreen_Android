package kz.kairliyev.loginscreen_android.ui.login.interactor

import kz.kairliyev.loginscreen_android.data.network.LoginResponse
import kz.kairliyev.loginscreen_android.ui.base.interactor.AppInteractor
import kz.kairliyev.loginscreen_android.util.AppConstants
import io.reactivex.Observable
import io.reactivex.Single


interface LoginAppInteractor : AppInteractor {

    fun doServerLoginApiCall(email: String, password: String): Single<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}