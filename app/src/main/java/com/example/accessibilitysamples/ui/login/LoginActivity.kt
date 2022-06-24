package com.example.accessibilitysamples.ui.login

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.accessibilitysamples.R
import com.example.accessibilitysamples.databinding.ActivityLoginBinding
import com.example.accessibilitysamples.ui.home.HomeActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loadingDialog: Dialog
    private val presenter: LoginContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingDialog = Dialog(this).apply {
            setCancelable(false)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setContentView(R.layout.dialog_loading)
        }

        binding.tietUser.doOnTextChanged { text, _, _, _ ->
            presenter.onUsernameChanged(text)
        }
        binding.tietPass.doOnTextChanged { text, _, _, _ ->
            presenter.onPasswordChanged(text)
        }
        binding.btnLogin.setOnClickListener { presenter.onLogin() }
    }

    override fun setLoadingVisibility(isVisible: Boolean) {
        if (isVisible) {
            loadingDialog.show()
        } else {
            loadingDialog.dismiss()
        }
    }

    override fun isValidUser(isValid: Boolean) {
        binding.btnLogin.isEnabled = isValid
    }

    override fun loginSuccess() {
        HomeActivity.start(this)
        finish()
    }
}