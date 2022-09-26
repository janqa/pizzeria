package com.pizzeria.model

import javax.persistence.*

@Entity
@Table(name = "usr")
class User {
    @Id
    var email: String = ""

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var toppings: Set<Topping> = mutableSetOf()
}