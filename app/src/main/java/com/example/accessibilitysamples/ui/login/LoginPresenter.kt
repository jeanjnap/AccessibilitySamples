package com.example.accessibilitysamples.ui.login

import android.os.AsyncTask
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

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
        AsyncTask.execute {
            runBlocking {
                delay(1000)
                view.setLoadingVisibility(false)
                view.loginSuccess()
            }
        }
    }

    private fun verifyUserData() {
        view.isValidUser(user.isNotEmpty() && pass.isNotEmpty())
    }
}