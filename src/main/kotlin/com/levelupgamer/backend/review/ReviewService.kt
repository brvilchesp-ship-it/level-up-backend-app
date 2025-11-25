package com.levelupgamer.backend.review

import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val repo: ReviewRepository
) {

    fun findAll(): List<Review> = repo.findAll()

    fun findById(id: Long): Review =
        repo.findById(id).orElseThrow { RuntimeException("Review no encontrada") }

    fun findByProduct(productId: String): List<Review> =
        repo.findByProductId(productId)

    fun create(review: Review): Review = repo.save(review)

    fun delete(id: Long) = repo.deleteById(id)
}
