package com.pizzeria.controller

import com.pizzeria.service.api.ToppingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/toppings")
class ToppingController(private val toppingService: ToppingService) {

    @PutMapping("/{email}")
    fun saveToppings(
        @PathVariable email: String,
        @RequestBody request: Set<String>
    ): ResponseEntity<Set<String>> {
        return ResponseEntity.ok(toppingService.saveToppings(email, request))
    }

    @GetMapping("/statistics")
    fun getToppingsStatistics(): ResponseEntity<Map<String, Int>> {
        return ResponseEntity.ok(toppingService.getToppingUserCountMap())
    }

    @GetMapping("/{email}")
    fun getToppingsByEmail(@PathVariable email: String): ResponseEntity<Collection<String>> {
        return ResponseEntity.ok(toppingService.getToppingsByEmail(email))
    }
}
