package com.levelupgamer.backend.product

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Product(
    @Id
    val id: String = "",
    val name: String = "",
    val price: Int = 0,
    val category: String = "",
    val image: String = ""
)
