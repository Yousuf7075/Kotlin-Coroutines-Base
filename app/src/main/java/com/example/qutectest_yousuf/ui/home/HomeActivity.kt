package com.example.qutectest_yousuf.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.login.LoginViewModel
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    private lateinit var homeViewModel: HomeViewModel
    @set:Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = ViewModelProviders.of(this, providerFactory)[HomeViewModel::class.java]
        observeViewModel()
    }

    private fun observeViewModel() {
        homeViewModel.homeDataResponse.observe(this, Observer {
            Log.e("res",it.toString())
        })
    }
}