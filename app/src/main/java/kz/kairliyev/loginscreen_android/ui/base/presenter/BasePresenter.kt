package kz.kairliyev.loginscreen_android.ui.base.presenter

import kz.kairliyev.loginscreen_android.ui.base.interactor.AppInteractor
import kz.kairliyev.loginscreen_android.ui.base.view.AppView
import kz.kairliyev.loginscreen_android.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : AppView, I : AppInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : AppPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}