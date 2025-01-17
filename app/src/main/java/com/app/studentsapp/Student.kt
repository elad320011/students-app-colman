package com.app.studentsapp

data class Student(
    var id: String,
    var name: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean = false
)