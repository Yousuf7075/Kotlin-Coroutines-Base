package com.example.qutectest_yousuf.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qutectest_yousuf.network.Repository
import com.example.qutectest_yousuf.ui.home.model.HomeDataRP
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val homeDataResponse: LiveData<HomeDataRP> = MutableLiveData()

    init {
        viewModelScope.launch {
            try {
                homeDataResponse as MutableLiveData
                homeDataResponse.value = getHomeData()
            }catch (e: Exception){
                Log.e("error", e.localizedMessage)
            }
        }
    }

    private suspend fun getHomeData(): HomeDataRP{
        return withContext(Dispatchers.IO){
            repository.getHomeData()
        }
    }

}