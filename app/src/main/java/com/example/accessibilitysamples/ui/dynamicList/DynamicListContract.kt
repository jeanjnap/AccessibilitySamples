package com.example.accessibilitysamples.ui.dynamicList

object DynamicListContract {
    interface View {
        fun setLoadingVisibility(isVisible: Boolean)
        fun addItems(items: List<String>, startPosition: Int)
    }

    interface Presenter {
        fun getContent()
        fun onPageScrolled()
    }
}