package kz.kairliyev.loginscreen_android.ui.base.interactor

interface AppInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()

}