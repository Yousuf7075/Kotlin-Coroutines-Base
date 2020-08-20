package com.example.qutectest_yousuf.network.dataSource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.LiveDataReactiveStreams.fromPublisher
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.load.engine.Resource
import com.example.qutectest_yousuf.network.Endpoints
import com.example.qutectest_yousuf.network.RetrofitAPIFactory
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

class RemoteDataSource(val context: Context) {


    private var endpoints: Endpoints? = null

    //private var loginRP: MediatorLiveData<Resource<out LoginRP>>? = null

    init {
        endpoints = RetrofitAPIFactory.createService(context, 30)
    }

     fun userLogin(loginRQ: LoginRQ): Flowable<LoginRP> {
       return endpoints!!.userLogin(loginRQ)
    }

    /*fun getHomeDataList(): LiveData<Resource<out HomeRP>>{
        homeData =  MediatorLiveData()
        homeData!!.value = Resource.loading(null)
        val homeRpDefault: HomeRP? = null
        val source: LiveData<Resource<out HomeRP>> =
            LiveDataReactiveStreams.fromPublisher(
                endpoints?.getHomeDataList()
                    ?.onErrorReturn {
                        homeRpDefault
                    }?.map {
                        if (homeRpDefault == null){
                            Resource.authenticated(it)
                        }else{
                            Resource.error("Error", null)
                        }
                    }
                    ?.subscribeOn(Schedulers.io())!!
            )
        homeData!!.addSource(source, Observer {
            homeData!!.postValue(it)
            homeData!!.removeSource(source)
        })
        return homeData as MediatorLiveData<Resource<out HomeRP>>
    }*/

}