package com.example.qutectest_yousuf.di

import androidx.lifecycle.ViewModelProvider
import com.example.qutectest_yousuf.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Mohammad Yousuf on August, 2020
 *
 */
@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}