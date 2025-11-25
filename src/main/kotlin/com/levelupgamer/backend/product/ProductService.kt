package com.levelupgamer.backend.product

import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repo: ProductRepository
) {

    fun findAll(): List<Product> = repo.findAll()

    fun findById(id: String): Product =
        repo.findById(id).orElseThrow { RuntimeException("Producto no encontrado") }

    fun create(product: Product): Product =
        repo.save(product)

    fun update(id: String, updated: Product): Product {
        val existing = findById(id)
        val toSave = existing.copy(
            name = updated.name,
            price = updated.price,
            category = updated.category,
            image = updated.image
        )
        return repo.save(toSave)
    }

    fun delete(id: String) = repo.deleteById(id)
}
