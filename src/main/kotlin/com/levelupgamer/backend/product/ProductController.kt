package com.levelupgamer.backend.product

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val repo: ProductRepository
) {

    @GetMapping
    fun getAll(): List<Product> = repo.findAll()

    @PostMapping
    fun create(@RequestBody product: Product): Product = repo.save(product)
}
