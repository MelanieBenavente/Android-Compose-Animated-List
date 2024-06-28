package com.melaniadev.fitcare.ui

fun mockList(): List<Customer> {
    val customersList = listOf(
        Customer("Bernat", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.MALE, "37", null, null, null, null, null, null),
        Customer("Mel", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.FEMALE, "37", null, null, null, null, null, null),
        Customer("Marina", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.FEMALE, "37", null, null, null, null, null, null),
        Customer("Estela", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.FEMALE, "37", null, null, null, null, null, null),
        Customer("Nadine", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.FEMALE, "37", null, null, null, null, null, null),
        Customer("Ariel", "25/03/23", "07/05/24", Professional("Marco Aurelio", Therapy.PHYSICAL, null), Gender.MALE, "37", null, null, null, null, null, null),
    )
    return customersList
}
