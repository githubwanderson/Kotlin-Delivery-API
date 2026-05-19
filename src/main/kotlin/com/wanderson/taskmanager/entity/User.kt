package com.wanderson.taskmanager.entity

data class User(
    var id: Long? = null,
    var name: String,
    var email: String,
    var password: String,
    var active: Boolean = true
)