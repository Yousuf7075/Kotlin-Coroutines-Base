package com.example.qutectest_yousuf.di.login

import androidx.lifecycle.ViewModel
import com.example.qutectest_yousuf.di.ViewModelKey
import com.example.qutectest_yousuf.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class LoginViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindMainViewModel(viewModel: LoginViewModel): ViewModel
}