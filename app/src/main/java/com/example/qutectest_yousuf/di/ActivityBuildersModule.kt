package com.example.qutectest_yousuf.di

import com.example.qutectest_yousuf.di.login.LoginScope
import com.example.qutectest_yousuf.di.login.LoginViewModelsModule
import com.example.qutectest_yousuf.di.splash.SplashScope
import com.example.qutectest_yousuf.di.splash.SplashViewModelsModule
import com.example.qutectest_yousuf.ui.login.LoginActivity
import com.example.qutectest_yousuf.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {
    @SplashScope
    @JvmSuppressWildcards
    @ContributesAndroidInjector(modules = [SplashViewModelsModule::class])
    internal abstract fun contributeSplashActivity(): SplashActivity

    @LoginScope
    @JvmSuppressWildcards
    @ContributesAndroidInjector(modules = [LoginViewModelsModule::class])
    internal abstract fun contributeLoginActivity(): LoginActivity
}