package uz.abpay.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.mobiler.data.datasource.network.ApiService
import uz.mobiler.data.datasource.repository.UserRepositoryImpl
import uz.mobiler.domain.repository.UserRepository

@Module(includes = [DataModule.BindModule::class])
object DataModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Module
    abstract class BindModule {
        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}