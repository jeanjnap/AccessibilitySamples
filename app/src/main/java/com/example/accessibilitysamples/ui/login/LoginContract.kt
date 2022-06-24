package com.example.accessibilitysamples.ui.login

object LoginContract {
    interface View {
        fun setLoadingVisibility(isVisible: Boolean)
        fun isValidUser(isValid: Boolean)
        fun loginSuccess()
    }

    interface Presenter {
        fun onUsernameChanged(username: CharSequence?)
        fun onPasswordChanged(password: CharSequence?)
        fun onLogin()
    }
}