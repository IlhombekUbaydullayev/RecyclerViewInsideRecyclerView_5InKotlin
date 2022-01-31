package com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter

import android.content.Context
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.recyclerviewinsiderecyclerview_5inkotlin.R

class CustomSubAdabter(private val context: Context, private val memberSubs: List<MemberSub>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val footer = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_custom_layout_view_sub, viewGroup, false)
        return CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val memberSub = memberSubs[position]
    }

    override fun getItemCount(): Int {
        return memberSubs.size
    }

     class CustomViewHolder(var view: View) : RecyclerView.ViewHolder(
        view
    )
}