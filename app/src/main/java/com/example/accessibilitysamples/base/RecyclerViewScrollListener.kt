package com.example.accessibilitysamples.base

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewScrollListener(
    private val onTransactionsScrolled: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        safeLet(
            recyclerView.layoutManager?.cast<LinearLayoutManager>(),
            recyclerView.adapter?.itemCount
        ) { layoutManager, itemCount ->
            val lastVisiblePosition = layoutManager.findLastCompletelyVisibleItemPosition()
            if (itemCount > ZERO_VALUE && (itemCount - ONE_VALUE) == lastVisiblePosition) {
                onTransactionsScrolled.invoke()
            }
        }
    }

    companion object {
        private const val ZERO_VALUE = 0
        private const val ONE_VALUE = 1
    }
}
