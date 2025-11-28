package com.levelupgamer.backend.cart

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "cart_items")
data class CartItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val userEmail: String = "",

    @Column(nullable = false)
    val productId: String = "",

    @Column(nullable = false)
    val productName: String = "",

    @Column(nullable = false)
    val qty: Int = 0,

    @Column(nullable = false)
    val unitPrice: Int = 0,

    @Column(nullable = false)
    val lineTotal: Int = 0,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
