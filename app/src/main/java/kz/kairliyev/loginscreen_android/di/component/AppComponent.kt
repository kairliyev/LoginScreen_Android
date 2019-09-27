package kz.kairliyev.loginscreen_android.di.component

import android.app.Application
import kz.kairliyev.loginscreen_android.di.builder.ActivityBuilder
import kz.kairliyev.loginscreen_android.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kz.kairliyev.loginscreen_android.App
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}