package com.example.qutectest_yousuf.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.base.BaseActivity
import com.example.qutectest_yousuf.ui.login.LoginActivity

class SplashActivity : BaseActivity() {
    private val SPLASH_DISPLAY_TIMER = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            finish()

            /*if (Hawk.contains(Constants.SAVED_USER_EMAIL)) {
                val mainIntent =
                    Intent(this@SplashActivity, LandingTabActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
                finish()
            } else {
                val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
                finish()
            }*/
        }, SPLASH_DISPLAY_TIMER.toLong())
    }
}