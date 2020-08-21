package com.example.qutectest_yousuf.di.home

import androidx.lifecycle.ViewModel
import com.example.qutectest_yousuf.di.ViewModelKey
import com.example.qutectest_yousuf.ui.home.HomeViewModel
import com.example.qutectest_yousuf.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class HomeViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMainViewModel(viewModel: HomeViewModel): ViewModel
}