package uz.abpay.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.abpay.support.viewmodel.UserViewModel
import uz.abpay.support.viewmodel.ViewModelFactory
import uz.abpay.support.viewmodel.ViewModelKey

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModel(userViewModel: UserViewModel): ViewModel
}