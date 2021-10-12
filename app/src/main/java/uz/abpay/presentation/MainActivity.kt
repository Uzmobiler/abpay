package uz.abpay.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.abpay.App
import uz.abpay.R
import uz.abpay.support.viewmodel.UserResource
import uz.abpay.support.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by viewModels { factory }

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getUsers()
        viewModel.userLiveData.observe(this, Observer {
            when (it) {
                is UserResource.Failure -> {

                }
                is UserResource.Load -> {

                }
                is UserResource.InitialState -> {

                }
                is UserResource.Success -> {
                    Log.d(TAG, "onCreate: ${it.list}")
                }
            }
        })
    }
}