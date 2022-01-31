package com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter.CustomAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.recyclerviewinsiderecyclerview_5inkotlin.R
import com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter.CustomAdapter.CustomListHolder
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub
import com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter.CustomSubAdabter
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.Member

class CustomAdapter(val context: Context,val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private val TYPE_ITEM_VIEW = 0
        private val TYPE_ITEM_List = 1
    }

    override fun getItemViewType(position: Int): Int {

        return if (members[position].memberSubs!!.isNotEmpty()) TYPE_ITEM_List else TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_List) {
            val header = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_custom_layout_list, viewGroup, false)
            return CustomListHolder(header)
        }
        val footer = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_custom_layout_view, viewGroup, false)
        return CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if (holder is CustomViewHolder) {
        }
        if (holder is CustomListHolder) {
            val recyclerView = holder.recyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 1)
            val memberSubs = member.memberSubs
            if (memberSubs != null) {
                refreshSubAdabter(recyclerView, memberSubs)
            }
        }
    }

    private fun refreshSubAdabter(recyclerView: RecyclerView, memberSubs: List<MemberSub>) {
        val adapter = CustomSubAdabter(context, memberSubs)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return members.size
    }

    private inner class CustomViewHolder(var view: View) : RecyclerView.ViewHolder(
        view
    )

    private inner class CustomListHolder(var view: View) : RecyclerView.ViewHolder(
        view
    ) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
        }
    }


}