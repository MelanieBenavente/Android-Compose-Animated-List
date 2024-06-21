package com.melaniadev.fitcare.ui

data class Customer(
    private val customerName: String,
    val lastVisit: String?,
    val nextVisit: String?,
    val professional: Professional,
    val gender: Gender,
    val age: String?,
    val weight: String?,
    val height: String?,
    val email: String?,
    val phone: String?,
    val imageUrl: String?,
    val visitHistory: List<Visit>?): User(customerName)

enum class Gender(val genderType: String){
    MALE(genderType = "Male"),
    FEMALE(genderType = "Female")
}