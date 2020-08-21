package com.example.qutectest_yousuf.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityLoginBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.home.HomeActivity
import com.example.qutectest_yousuf.ui.login.model.LoginRQ
import com.example.qutectest_yousuf.utils.Status
import javax.inject.Inject

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

            //fetch response
            observeViewModel(loginRQ)
        }else{
            hideLoading()
            Toast.makeText(this, "user name or password missing!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeViewModel(loginRQ: LoginRQ) {
        loginViewModel.userLogin(loginRQ).observe(this, Observer {
            it.let {resource ->
                when(resource.status){
                    Status.SUCCESS ->{
                        Log.e("data", resource.data.toString())
                        hideLoading()
                        if (resource.data!!.msg == "Login Success"){
                            navigateToHomeActivity()
                        }
                    }
                    Status.LOADING ->{
                        showLoading()
                    }
                    Status.ERROR -> {
                        hideLoading()
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}

