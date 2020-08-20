package com.example.qutectest_yousuf.network

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.qutectest_yousuf.network.dataSource.RemoteDataSource
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import io.reactivex.Flowable
import retrofit2.Call
import javax.inject.Inject


/**
 * Created by Mohammad Yousuf on August, 2020
 *
 */

class Repository @Inject constructor(context: Context) {


    //Initialize
    private val remoteDataSource = RemoteDataSource(context)

    suspend fun userLogin(loginRQ: LoginRQ): LoginRP {
        return remoteDataSource.userLogin(loginRQ)
    }
}