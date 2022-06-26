package com.example.accessibilitysamples.ui.readCustomText

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitysamples.R
import com.example.accessibilitysamples.databinding.ActivityCustomReadBinding
import com.example.accessibilitysamples.extensions.setContentDescriptionCpf
import com.example.accessibilitysamples.extensions.setContentDescriptionMobileNumber

class CustomReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.custom_read)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeActionContentDescription(R.string.go_back)

        setAccessibility()
    }

    private fun setAccessibility() {
        binding.tvCpf.setContentDescriptionCpf()
        binding.tvMobileNumber.setContentDescriptionMobileNumber()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CustomReadActivity::class.java))
        }
    }
}