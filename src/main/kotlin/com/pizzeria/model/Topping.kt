package com.pizzeria.model

import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@javax.persistence.Entity
@Table(name = "topping")
class Topping() {
    @Id
    var name: String = ""

    @ManyToMany(mappedBy = "toppings", fetch = FetchType.LAZY)
     var users: Set<User> = mutableSetOf()

    constructor(topping: String) : this() {
        this.name = topping
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Topping

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}