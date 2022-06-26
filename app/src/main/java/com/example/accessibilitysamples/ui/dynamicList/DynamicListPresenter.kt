package com.example.accessibilitysamples.ui.dynamicList

import android.os.Handler
import android.os.Looper

class DynamicListPresenter(
    private val view: DynamicListContract.View
) : DynamicListContract.Presenter {

    private var currentPage = 1
    private val items = mutableListOf<String>()

    override fun getContent() {
        view.setLoadingVisibility(true)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                repeat(PAGE_SIZE) {
                    items.add("Item número ${items.size.inc()}")
                }
                view.setLoadingVisibility(false)
                view.addItems(items, items.size -PAGE_SIZE)
            },
            1500L
        )
    }

    override fun onPageScrolled() {
        currentPage ++
        getContent()
    }

    private companion object {
        const val PAGE_SIZE = 20
    }
}