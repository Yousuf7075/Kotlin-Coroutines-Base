package com.example.qutectest_yousuf.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import com.example.qutectest_yousuf.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun userLogin(loginRQ: LoginRQ) = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.userLogin(loginRQ)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}

