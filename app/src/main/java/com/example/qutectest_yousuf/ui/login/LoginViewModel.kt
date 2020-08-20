package com.example.qutectest_yousuf.ui.login

import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import io.reactivex.Flowable
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {

     fun userLogin(loginRQ: LoginRQ): Flowable<LoginRP> {
        return repository.userLogin(loginRQ)
    }


    /*fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }*/
}