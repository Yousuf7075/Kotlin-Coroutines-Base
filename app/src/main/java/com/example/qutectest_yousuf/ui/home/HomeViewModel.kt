package com.example.qutectest_yousuf.ui.home

import androidx.lifecycle.*
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.utils.Resource
import kotlinx.coroutines.Dispatchers
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