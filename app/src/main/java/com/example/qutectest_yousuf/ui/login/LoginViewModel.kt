package com.example.qutectest_yousuf.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {

     val loginResponse = MutableLiveData<LoginRP>()

    fun userLogin(loginRQ: LoginRQ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    val response = repository.userLogin(loginRQ)
                    Log.e("res", response.toString())
                    loginResponse.postValue(response)
                } catch (e: Exception){
                    Log.e("error", e.localizedMessage)
                }
            }
        }
    }

}