package com.levelupgamer.backend.user

import com.levelupgamer.backend.model.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
class UserController(
    private val service: UserService
) {

    // Obtener todos (si tu profe lo pide)
    @GetMapping
    fun getAll(): List<User> = service.findAll()

    // Buscar usuario por email
    @GetMapping("/{email}")
    fun getByEmail(@PathVariable email: String): User =
        service.findByEmail(email)

    // Actualizar usuario (nombre, puntos o lo que sea)
    @PutMapping("/{email}")
    fun update(@PathVariable email: String, @RequestBody updated: User): User =
        service.update(email, updated)

    // Eliminar usuario
    @DeleteMapping("/{email}")
    fun delete(@PathVariable email: String) =
        service.delete(email)

}
