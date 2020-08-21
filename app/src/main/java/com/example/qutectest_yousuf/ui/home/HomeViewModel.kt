package com.example.qutectest_yousuf.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.ui.home.model.HomeDataRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import com.example.qutectest_yousuf.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getHomeData() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getHomeData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}