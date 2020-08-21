package com.example.qutectest_yousuf.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.databinding.ActivityHomeBinding
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import com.example.qutectest_yousuf.ui.home.model.Data
import com.example.qutectest_yousuf.utils.CustomRecyclerItemSpaceDecoration
import com.example.qutectest_yousuf.utils.Status
import javax.inject.Inject


class HomeActivity : BaseActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    private lateinit var homeViewModel: HomeViewModel
    @set:Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        initToolbar()

        homeViewModel = ViewModelProviders.of(this, providerFactory)[HomeViewModel::class.java]
        showLoading()
        observeViewModel()
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun initToolbar() {
        setSupportActionBar(homeBinding.toolbar)
        homeBinding.toolbar.title = "Home"
    }

    private fun observeViewModel() {
        homeViewModel.getHomeData().observe(this, Observer {
            it.let {resource ->
                when(resource.status){
                    Status.SUCCESS ->{
                        Log.e("data", resource.data.toString())
                        hideLoading()
                        initAdapter(resource.data!!.data as ArrayList<Data>)
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

    private fun initAdapter(items: ArrayList<Data>) {
        homeBinding.homeRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        homeBinding.homeRecycler.setHasFixedSize(true)
        val itemSpaceDecoration = CustomRecyclerItemSpaceDecoration(35,10,35,35,40,0)
        homeBinding.homeRecycler.addItemDecoration(itemSpaceDecoration)
        val adapter = HomeAdapter(items)
        homeBinding.homeRecycler.adapter = adapter
    }
}