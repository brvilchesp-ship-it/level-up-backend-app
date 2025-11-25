package com.levelupgamer.backend.review

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val productId: String = "",
    val authorEmail: String = "",
    val stars: Int = 0,
    val text: String = "",
    val ts: Long = System.currentTimeMillis()
)
