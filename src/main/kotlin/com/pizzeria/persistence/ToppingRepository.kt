package com.pizzeria.persistence

import com.pizzeria.model.Topping
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ToppingRepository : CrudRepository<Topping, String>