package com.core.materialmotionform

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.materialmotionform.databinding.CvBonafideItemBinding

class BonafideAdapter(private val bonafides : List<Bonafide>)
    : RecyclerView.Adapter<BonafideAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            CvBonafideItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = bonafides.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(bonafides[position])

    class ViewHolder(val binding: CvBonafideItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(bonafide: Bonafide) {
            binding.bonafide = bonafide
        }
    }
}