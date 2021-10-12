package uz.mobiler.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.mobiler.domain.models.User
import uz.mobiler.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun getUsers(): Flow<Result<List<User>>> {
        return userRepository.getUsers()
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }
            .flowOn(Dispatchers.IO)
    }
}