package uz.mobiler.data.datasource.repository

import kotlinx.coroutines.flow.Flow
import uz.mobiler.data.datasource.network.ApiService
import uz.mobiler.domain.models.User
import uz.mobiler.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return apiService.getUsers()
    }
}