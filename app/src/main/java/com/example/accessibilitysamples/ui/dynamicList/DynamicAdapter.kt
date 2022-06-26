package com.example.accessibilitysamples.ui.dynamicList

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.accessibilitysamples.base.BaseViewHolder
import com.example.accessibilitysamples.databinding.ItemDynamicBinding
import com.example.accessibilitysamples.extensions.isOdd

class DynamicAdapter : Adapter<BaseViewHolder>() {

    private var list = listOf<String>()

    fun addItems(items: List<String>, startPosition: Int) {
        list = items
        notifyItemRangeChanged(startPosition, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(
        ItemDynamicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding = ItemDynamicBinding.bind(holder.itemView)
        binding.clMain.setBackgroundColor(
            if (position.isOdd()) {
                Color.GRAY
            } else {
                Color.WHITE
            }
        )
        binding.tvTitle.text = list[position]
    }

    override fun getItemCount() = list.size
}
