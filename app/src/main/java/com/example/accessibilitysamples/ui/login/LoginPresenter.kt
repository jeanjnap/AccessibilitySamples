package com.example.accessibilitysamples.ui.login

import android.os.Handler
import android.os.Looper

class LoginPresenter(
    private val view: LoginContract.View
) : LoginContract.Presenter {
    private var user: String = ""
    private var pass: String = ""

    override fun onUsernameChanged(username: CharSequence?) {
        user = username?.toString().orEmpty()
        verifyUserData()
    }

    override fun onPasswordChanged(password: CharSequence?) {
        pass = password?.toString().orEmpty()
        verifyUserData()
    }

    override fun onLogin() {
        view.setLoadingVisibility(true)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                view.setLoadingVisibility(false)
                view.loginSuccess()
            },
            1000L
        )
    }

    private fun verifyUserData() {
        view.isValidUser(user.isNotEmpty() && pass.isNotEmpty())
    }
}