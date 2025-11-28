package com.levelupgamer.backend.cart

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(
    private val cartRepository: CartItemRepository
) {

    // 🚀 GET /api/cart -> TODOS (solo para probar en navegador)
    @GetMapping
    fun getAll(): List<CartItem> =
        cartRepository.findAll()

    // 🚀 GET /api/cart/{email} -> carrito por usuario
    @GetMapping("/{email}")
    fun getCart(@PathVariable email: String): List<CartItem> =
        cartRepository.findByUserEmail(email)

    // 🚀 POST /api/cart -> agregar línea
    @PostMapping
    fun addItem(@RequestBody req: AddCartItemRequest): CartItem {
        val item = CartItem(
            userEmail = req.userEmail,
            productId = req.productId,
            productName = req.productName,
            qty = req.qty,
            unitPrice = req.unitPrice,
            lineTotal = req.qty * req.unitPrice
        )
        return cartRepository.save(item)
    }

    // 🚀 DELETE /api/cart/{id} -> eliminar una línea del carrito
    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long) =
        cartRepository.deleteById(id)
}

data class AddCartItemRequest(
    val userEmail: String,
    val productId: String,
    val productName: String,
    val qty: Int,
    val unitPrice: Int
)
