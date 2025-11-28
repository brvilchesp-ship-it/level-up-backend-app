package com.levelupgamer.backend.product

import com.levelupgamer.backend.model.Product
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class ProductDataLoader(
    private val productRepository: ProductRepository
) {

    @PostConstruct
    fun init() {
        // Si ya hay productos, no hacemos nada
        if (productRepository.count() > 0) return

        val products = listOf(
            Product(
                id = "ps5",
                name = "PlayStation 5",
                price = 599_990,
                category = "Consolas",
                image = "https://media.falabella.com/falabellaCL/144879483_01/w=1500,h=1500,fit=pad"
            ),
            Product(
                id = "pc-rog",
                name = "PC Gamer ASUS ROG Strix",
                price = 980_000,
                category = "Computadores Gamers",
                image = "https://media.solotodo.com/media/products/1376804_picture_1619193737.jpg"
            ),
            Product(
                id = "hyperx",
                name = "Auriculares Gamer HyperX Cloud II",
                price = 36_990,
                category = "Accesorios",
                image = "https://media.solotodo.com/media/products/1666477_picture_1668178725.jpg"
            ),
            Product(
                id = "pc-pba",
                name = "PC Gaming Asus Rog Strix PBA",
                price = 5_699_990,
                category = "Computadores Gamers",
                image = "https://www.xtremepc.com.mx/cdn/shop/files/f2d07544-3b3d-49d1-bd86-f2ec23b62c8e_800x.png?v=1732267809"
            ),
            Product(
                id = "apexpro",
                name = "Apex Pro TKL Gen3",
                price = 300_790,
                category = "Accesorios",
                image = "https://http2.mlstatic.com/D_NQ_NP_777006-MLA80570414748_112024-O.webp"
            ),
            Product(
                id = "polera",
                name = "Polera Gamer Personalizada 'Level-Up'",
                price = 14_990,
                category = "Poleras Personalizadas",
                image = "https://cdnx.jumpseller.com/estampados-bettoskys/image/29748856/resize/640/640?1669413482"
            ),
            Product(
                id = "poleron",
                name = "Polerón Gamer Personalizado 'Level-Up'",
                price = 42_990,
                category = "Polerones Gamers Personalizados",
                image = "https://http2.mlstatic.com/D_NQ_NP_746963-MLC53433072044_012023-O.webp"
            ),
            Product(
                id = "silla-gamer",
                name = "Silla Gamer RGB Reclinable",
                price = 129_990,
                category = "Sillas Gamers",
                image = "https://http2.mlstatic.com/D_NQ_NP_2X_825627-MLA95686798840_102025-F.webp"
            ),
            Product(
                id = "mouse-g502",
                name = "Mouse Gamer Logitech G502 HERO",
                price = 49_990,
                category = "Mouse",
                image = "https://http2.mlstatic.com/D_NQ_NP_2X_650155-MLA95691271012_102025-F.webp"
            ),
            Product(
                id = "mousepad-rgb",
                name = "Mousepad Gamer RGB XL",
                price = 19_990,
                category = "Mousepad",
                image = "https://http2.mlstatic.com/D_NQ_NP_2X_869138-MLA95634011680_102025-F.webp"
            ),
            Product(
                id = "juego-mesa",
                name = "Juego de Mesa Monopoly Gamer",
                price = 29_990,
                category = "Juegos de Mesa",
                image = "https://http2.mlstatic.com/D_NQ_NP_2X_981584-MLA95676703140_102025-F.webp"
            )
        )

        productRepository.saveAll(products)
        println("✅ Productos demo insertados en la BD")
    }
}
