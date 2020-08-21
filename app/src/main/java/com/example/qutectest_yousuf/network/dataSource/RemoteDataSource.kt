package com.example.qutectest_yousuf.network.dataSource

import android.content.Context
import com.example.qutectest_yousuf.network.Endpoints
import com.example.qutectest_yousuf.network.RetrofitAPIFactory
import com.example.qutectest_yousuf.ui.home.model.HomeDataRP
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ

class RemoteDataSource(val context: Context) {


    private var endpoints: Endpoints? = null

    init {
        endpoints = RetrofitAPIFactory.createService(context, 30)
    }

     suspend fun userLogin(loginRQ: LoginRQ): LoginRP {
       return endpoints!!.userLogin(loginRQ)
    }

    suspend fun getHomeData(): HomeDataRP {
        return endpoints!!.getHomeData()
    }

}