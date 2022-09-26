package com.pizzeria.service

import com.pizzeria.model.Topping
import com.pizzeria.model.User
import com.pizzeria.persistence.ToppingRepository
import com.pizzeria.persistence.UserRepository
import com.pizzeria.service.api.ToppingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service

@Service
@ConditionalOnProperty(prefix = "topping", name = ["service"], havingValue = "db")
class ToppingsServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val toppingRepository: ToppingRepository
) : ToppingService {

    override fun saveToppings(email: String, toppings: Set<String>): Set<String> {
        val user: User = map(email, toppings)
        return userRepository.save(user).toppings
            .map(Topping::name).toSet()
    }

    override fun getToppingUserCountMap(): Map<String, Int> {
        return toppingRepository.findAll()
            .filter { t -> t.users.isNotEmpty() }
            .associate { t -> Pair(t.name, t.users.size) }
    }

    override fun getToppingsByEmail(email: String): Collection<String> {
        return userRepository.findById(email)
            .map(User::toppings)
            .orElse(emptySet())
            .map(Topping::name)
    }

    private fun map(email: String, toppings: Set<String>): User {
        val user = User()
        user.email = email
        user.toppings = toppings.map(::Topping).toSet()
        return user
    }
}


