package com.example.qutectest_yousuf.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.qutectest_yousuf.R
import com.example.qutectest_yousuf.databinding.HomeItemRowBinding
import com.example.qutectest_yousuf.ui.home.model.Data

class HomeAdapter(private val homeItems: ArrayList<Data>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val homeItemBinding: HomeItemRowBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.home_item_row, parent, false)
        return HomeViewHolder(homeItemBinding)
    }

    override fun getItemCount(): Int {
        return homeItems.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeItems[position])
    }

    class HomeViewHolder(private val homeItemBinding: HomeItemRowBinding) : RecyclerView.ViewHolder(homeItemBinding.root) {
        fun bind(item: Data) {
            homeItemBinding.idValueTv.text = item.id.toString()
            homeItemBinding.titleValueTv.text = item.title
            homeItemBinding.surveyDateValueTv.text = item.surveyDate
            homeItemBinding.surveyAreaValueTv.text = item.surveyArea
        }

    }
}