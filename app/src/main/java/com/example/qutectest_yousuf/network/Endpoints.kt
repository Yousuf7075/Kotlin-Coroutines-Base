package com.example.qutectest_yousuf.network



import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import com.example.qutectest_yousuf.utils.AppConstants
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.*

interface Endpoints{

    @Headers("Authorization: ${AppConstants.TOKEN}")
    @POST("token/")
     fun userLogin( @Body loginRQ: LoginRQ): Flowable<LoginRP>
}