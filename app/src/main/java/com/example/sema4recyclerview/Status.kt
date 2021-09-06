package com.example.sema4recyclerview

import java.io.Serializable
import java.util.*

class Status: Serializable {

    var id: String
    var username: String
    var statusDesc: String
    var date: Calendar
    var likes: Int

    constructor(id: String, username: String, statusDesc: String, date: Calendar, likes: Int) {
        this.id = id
        this.username = username
        this.statusDesc = statusDesc
        this.date = date
        this.likes = likes
    }
}