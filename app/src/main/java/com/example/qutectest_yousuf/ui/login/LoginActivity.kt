package com.example.qutectest_yousuf.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityLoginBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.home.HomeActivity
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

class LoginActivity : BaseActivity(){

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
            showLoading()
            checkUserInput()
        }

    }

    private fun checkUserInput() {
        val userName = activityLoginBinding.userNameET.text.toString()
        val password = activityLoginBinding.passwordET.text.toString()
        if (userName.isNotEmpty() && password.isNotEmpty()){
            loginRQ = LoginRQ(userName, password)
            Log.e("RQ", loginRQ.toString())
            loginViewModel.userLogin(loginRQ)

            //fetch response
            observeViewModel()
        }else{
            hideLoading()
            Toast.makeText(this, "user name or password missing!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeViewModel() {
        loginViewModel.loginResponse.observe(this, Observer {
            hideLoading()
            Log.e("res", it.toString())
            if (it.msg == "Login Success"){
                Toast.makeText(this,"Login Success", Toast.LENGTH_LONG).show()
                navigateToHomeActivity()
            }
        })
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}

