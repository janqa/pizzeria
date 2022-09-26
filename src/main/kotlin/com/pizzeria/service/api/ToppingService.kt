package com.pizzeria.service.api


interface ToppingService {
    fun saveToppings(email: String, toppings: Set<String>): Set<String>
    fun getToppingUserCountMap(): Map<String, Int>
    fun getToppingsByEmail(email: String): Collection<String>
}