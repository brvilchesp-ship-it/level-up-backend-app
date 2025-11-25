package com.levelupgamer.backend.review

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByProductId(productId: String): List<Review>
}
