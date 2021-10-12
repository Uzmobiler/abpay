package uz.abpay

import android.app.Application
import uz.abpay.di.AppComponent
import uz.abpay.di.DaggerAppComponent
import javax.inject.Inject

class App @Inject constructor() : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        appComponent.inject(this)
    }
}