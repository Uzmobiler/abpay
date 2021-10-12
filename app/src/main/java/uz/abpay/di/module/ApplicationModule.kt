package uz.abpay.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.mobiler.data.datasource.network.FlowCallAdapterFactory
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowCallAdapterFactory)
            .baseUrl(baseUrl)
            .build()
    }


}