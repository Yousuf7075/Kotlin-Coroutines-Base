package com.example.qutectest_yousuf.ui.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityLoginBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.login.model.LoginRP
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import okhttp3.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

class LoginActivity : BaseActivity() {

    lateinit var activityLoginBinding: ActivityLoginBinding
    lateinit var loginRQ: LoginRQ
    private lateinit var loginViewModel: LoginViewModel
    @set:Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this, providerFactory)[LoginViewModel::class.java]

        activityLoginBinding.loginBtn.setOnClickListener {
            observeViewModel()
        }

    }

    @SuppressLint("CheckResult")
    private  fun observeViewModel() {
        val userName = activityLoginBinding.userNameET.text.toString()
        val password = activityLoginBinding.passwordET.text.toString()
        if (userName.isNotEmpty() && password.isNotEmpty()){
            loginRQ = LoginRQ(userName, password)
            Log.e("RQ", loginRQ.toString())
            loginViewModel.userLogin(loginRQ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess,this::onError)

        }
    }

    private fun onSuccess(loginRP: LoginRP){
        Log.e("response", loginRP.toString())
    }

    private fun onError(throwable: Throwable){
        Log.e("error", throwable.localizedMessage)
    }

}

