package uz.abpay.support.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import uz.mobiler.domain.interactor.UserInteractor
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {

    private val userRequest: MutableLiveData<Unit> = MutableLiveData()

    val userLiveData: LiveData<UserResource> by lazy {
        userRequest.switchMap {
            val flow: Flow<UserResource> =
                when {
                    it != null -> userInteractor.getUsers()
                        .map {
                            if (it.isSuccess) UserResource.Success(it.getOrDefault(emptyList()))
                            else {
                                UserResource.Failure(checkNotNull(it.exceptionOrNull()))
                            }
                        }
                        .catch {
                            UserResource.Failure(it)
                        }
                        .onStart { emit(UserResource.Load) }
                        .onCompletion { userRequest.value = null }
                    else -> emptyFlow()
                }
            return@switchMap flow.asLiveData(viewModelScope.coroutineContext)
        }
    }

    fun getUsers() {
        if (userRequest.value == null)
            userRequest.value = Unit
    }
}