package uz.mobiler.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.mobiler.domain.models.User

interface UserRepository {

    fun getUsers(): Flow<List<User>>
}