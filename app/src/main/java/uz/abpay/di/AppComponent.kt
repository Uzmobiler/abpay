package uz.abpay.di

import dagger.BindsInstance
import dagger.Component
import uz.abpay.App
import uz.abpay.di.module.ApplicationModule
import uz.abpay.di.module.DataModule
import uz.abpay.di.module.ViewModelModule
import uz.abpay.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App
        ): AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}