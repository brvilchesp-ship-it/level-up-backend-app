package com.levelupgamer.backend.product

import com.levelupgamer.backend.model.Product
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
class ProductController(
    private val service: ProductService
) {

    @GetMapping
    fun getAll(): List<Product> = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Product = service.findById(id)

    @PostMapping
    fun create(@RequestBody p: Product): Product = service.create(p)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody p: Product): Product =
        service.update(id, p)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.delete(id)
}
