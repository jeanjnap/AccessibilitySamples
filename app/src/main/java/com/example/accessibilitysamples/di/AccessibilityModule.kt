package com.example.accessibilitysamples.di

import com.example.accessibilitysamples.ui.login.LoginContract
import com.example.accessibilitysamples.ui.login.LoginPresenter
import org.koin.dsl.module

object AccessibilityModule {
    val instance = module {
        factory<LoginContract.Presenter> { (view: LoginContract.View) ->
            LoginPresenter(
                view = view
            )
        }
    }
}