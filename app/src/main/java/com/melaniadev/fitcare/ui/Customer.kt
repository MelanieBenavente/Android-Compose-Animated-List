package com.melaniadev.fitcare.ui

data class Customer(val name: String, val lastVisit: String?, val nextVisit: String?, val physiotherapist: String, val gender: Gender, val age: String?, val weight: String?, val height: String?, val email: String?, val phone: String?, val imageUrl: String?, val visitHistory: List<Visit>?)

enum class Gender(val genderType: String){
    MALE(genderType = "Male"),
    FEMALE(genderType = "Female")
}