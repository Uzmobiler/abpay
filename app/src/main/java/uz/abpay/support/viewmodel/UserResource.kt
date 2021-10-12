package uz.abpay.support.viewmodel

import uz.mobiler.domain.models.User

sealed class UserResource {

    object InitialState : UserResource()

    object Load : UserResource()

    data class Success(val list: List<User>) : UserResource()

    data class Failure(val throwable: Throwable) : UserResource()
}