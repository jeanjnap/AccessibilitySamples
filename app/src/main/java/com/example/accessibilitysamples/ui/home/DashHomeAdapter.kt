package com.example.accessibilitysamples.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.accessibilitysamples.base.BaseViewHolder
import com.example.accessibilitysamples.databinding.ItemDashHomeBinding

class DashHomeAdapter(
    private val onItemClick: (Int) -> Unit
) : Adapter<BaseViewHolder>() {

    private var list: List<DashItem> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = BaseViewHolder(
        ItemDashHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding = ItemDashHomeBinding.bind(holder.itemView)
        list.getOrNull(position)?.let { item ->
            binding.clItemAdmDash.apply {
                contentDescription = CONTENT_DESCRIPTION_FORMAT.format(item.title, item.description)
                setOnClickListener { onItemClick.invoke(position) }
            }
            binding.tvDashTitle.text = item.title
            binding.tvDashDescription.text = item.description
        }
    }

    override fun getItemCount() = list.size

    fun submitList(newList: List<DashItem>) {
        list = newList
        notifyDataSetChanged()
    }

    companion object {
        private const val CONTENT_DESCRIPTION_FORMAT = "%s %s"
    }
}
