package com.example.accessibilitysamples.ui.dynamicList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitysamples.R
import com.example.accessibilitysamples.base.RecyclerViewScrollListener
import com.example.accessibilitysamples.databinding.ActivityDynamicListBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DynamicListActivity : AppCompatActivity(), DynamicListContract.View {

    private val dynamicAdapter = DynamicAdapter()
    private lateinit var binding: ActivityDynamicListBinding
    private val presenter: DynamicListContract.Presenter by inject {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.dynamic_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeActionContentDescription(R.string.go_back)
        setRecyclerView()
        presenter.getContent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setLoadingVisibility(isVisible: Boolean) {
        if (isVisible) {
            binding.pbLoadingMore.show()
        } else {
            binding.pbLoadingMore.hide()
        }
    }

    override fun addItems(items: List<String>, startPosition: Int) {
        dynamicAdapter.addItems(items, startPosition)
    }

    private fun setRecyclerView() {
        binding.rvDynamicList.apply {
            adapter = dynamicAdapter
            addOnScrollListener(RecyclerViewScrollListener { presenter.onPageScrolled() })
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DynamicListActivity::class.java))
        }
    }
}