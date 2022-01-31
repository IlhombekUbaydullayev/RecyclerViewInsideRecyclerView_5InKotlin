package com.example.recyclerviewinsiderecyclerview_5inkotlin.model

import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub

class Member {
    var firstName: String? = null
    var lastName: String? = null
    var memberSubs: List<MemberSub>? = null

    constructor() {}
    constructor(firstName: String?, lastName: String?, memberSubs: List<MemberSub>?) {
        this.firstName = firstName
        this.lastName = lastName
        this.memberSubs = memberSubs
    }
}