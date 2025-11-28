package com.levelupgamer.backend.cart

import org.springframework.stereotype.Service

@Service
class CartService(
    private val repo: CartItemRepository
) {

    fun saveAll(items: List<CartItem>): List<CartItem> =
        repo.saveAll(items)

    fun findByUserEmail(email: String): List<CartItem> =
        repo.findByUserEmail(email)
}
