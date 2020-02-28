package com.tsvetomir.tonchev.trainproject.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.trainproject.R
import com.tsvetomir.tonchev.trainproject.data.model.local.TrainView

/**
 * Created by Tsvetomir.Tonchev on 2/28/2020.
 */
class TrainAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mTitle: String? = ""
    private var mCount = 0
    private lateinit var mTrainsList: List<TrainView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ITEM) {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item_info, parent, false)
            ItemHoled(view)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item_header, parent, false)
            HeaderHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return mCount
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderHolder) {
            handleHeaderView(holder)
        } else if (holder is ItemHoled) {
            handleItemView(holder, position - 1)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else TYPE_ITEM
    }

    private fun handleHeaderView(holder: HeaderHolder) {
        holder.title.text = mTitle

    }

    @SuppressLint("SetTextI18n")
    private fun handleItemView(holder: ItemHoled, position: Int) {
        val trainView = mTrainsList[position]
        holder.info.text =
            "${trainView.trainType} for ${trainView.destination} arrives ${trainView.expetArrival}"
    }

    fun loadData(title: String, data: List<TrainView>) {
        mTitle = title
        mTrainsList = data
        mCount = mTrainsList.size + 1
        notifyDataSetChanged()
    }

    class HeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_item)
    }

    class ItemHoled(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val info: TextView = itemView.findViewById(R.id.info_item)
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

}