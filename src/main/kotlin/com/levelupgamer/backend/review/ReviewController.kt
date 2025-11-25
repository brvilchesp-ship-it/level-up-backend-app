package com.levelupgamer.backend.review

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
class ReviewController(
    private val service: ReviewService
) {

    @GetMapping
    fun getAll(): List<Review> = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Review = service.findById(id)

    @GetMapping("/product/{productId}")
    fun getByProduct(@PathVariable productId: String): List<Review> =
        service.findByProduct(productId)

    @PostMapping
    fun create(@RequestBody review: Review): Review = service.create(review)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
