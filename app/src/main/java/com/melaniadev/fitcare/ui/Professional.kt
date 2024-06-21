package com.melaniadev.fitcare.ui

data class Professional(private val profName: String, val therapyType: Therapy?, val imageUrl: String?): User(profName)
enum class Therapy(val therapyType: String){
    PHYSICAL(therapyType = "Physiotherapist"),
    MASSAGE(therapyType = "Massage Therapist"),
    ACUPUNCTURE(therapyType = "Acupuncturist"),
    CHIROPRACTIC(therapyType = "Chiropractor")
}