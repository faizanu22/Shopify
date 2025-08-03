package com.example.shopify.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopify.R
import com.example.shopify.databinding.ItemCommonBinding
import com.example.shopify.ui.data.CommonDataClass

class CommonItemAdapter(
    val context: Context,
    private var itemList: ArrayList<CommonDataClass>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CommonItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCommonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position], onClickListener)
    }

    override fun getItemCount(): Int = itemList.size

    class OnClickListener(val clickListener: (itemData: CommonDataClass, clickType: Int) -> Unit) {
        fun onClick(itemData: CommonDataClass, clickType: Int) = clickListener(itemData, clickType)
    }

    inner class ItemViewHolder(private val binding: ItemCommonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataModal: CommonDataClass, onClickListener: OnClickListener) {
            Glide.with(context)
                .load(dataModal.image)
                .centerCrop()
                .placeholder(R.drawable.ic_app_logo)
                .into(binding.imageViewItem)

            binding.textViewItemName.text = dataModal.itemName
            binding.textViewItemDescription.text = dataModal.itemDescription
            binding.textViewItemPrice.text = dataModal.itemPrice

        }
    }
}