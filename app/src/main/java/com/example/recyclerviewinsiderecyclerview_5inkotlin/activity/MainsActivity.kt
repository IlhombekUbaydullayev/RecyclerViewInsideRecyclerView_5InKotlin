package com.example.recyclerviewinsiderecyclerview_5inkotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewinsiderecyclerview_5inkotlin.R
import com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter.CustomAdapter
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.Member
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub
import java.util.ArrayList

class MainsActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = GridLayoutManager(this, 1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this,members)
        recyclerView!!.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..29) {
            if (i == 1 || i == 10 || i == 16) {
                members.add(Member("Ilhombek$i", "Ubaydullayev$i", prepareSubMembers()))
            } else {
                members.add(Member("Ilhombek$i", "Ubaydullayev$i", ArrayList<MemberSub>()))
            }
        }
        return members
    }

    private fun prepareSubMembers(): List<MemberSub> {
        val members = ArrayList<MemberSub>()
        for (i in 0..4) {
            members.add(MemberSub("Offline"))
        }
        return members
    }
}