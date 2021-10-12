package uz.mobiler.data.datasource.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import uz.mobiler.domain.models.User

interface ApiService {

    @GET("users")
    fun getUsers(): Flow<List<User>>
}