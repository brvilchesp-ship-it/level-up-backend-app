package com.levelupgamer.backend.cart

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CartDataLoader(
    private val cartRepository: CartItemRepository
) {

    @PostConstruct
    fun init() {

        // Si ya hay items no agregamos nada
        if (cartRepository.count() > 0) return

        val demoCart = listOf(
            CartItem(
                userEmail = "brayan@duoc.cl",
                productId = "ps5",
                productName = "PlayStation 5",
                qty = 1,
                unitPrice = 599990,
                lineTotal = 599990,
                createdAt = LocalDateTime.now()
            ),
            CartItem(
                userEmail = "brayan@duoc.cl",
                productId = "mouse-g502",
                productName = "Logitech G502 HERO",
                qty = 2,
                unitPrice = 49990,
                lineTotal = 99980,
                createdAt = LocalDateTime.now()
            )
        )

        cartRepository.saveAll(demoCart)
        println("🛒 Carrito demo insertado en la BD")
    }
}
