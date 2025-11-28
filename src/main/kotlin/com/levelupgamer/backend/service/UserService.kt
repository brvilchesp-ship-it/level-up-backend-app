package com.levelupgamer.backend.user

import com.levelupgamer.backend.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repo: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun findAll(): List<User> = repo.findAll()

    fun findByEmail(email: String): User =
        repo.findByEmail(email) ?: throw RuntimeException("Usuario no encontrado")

    fun register(email: String, name: String, rawPassword: String): User {
        val isDuoc = email.lowercase().endsWith("@duocuc.cl")

        val newUser = User(
            email = email,
            name = name,
            duoc = isDuoc,
            points = 0,
            password = passwordEncoder.encode(rawPassword)
        )

        return repo.save(newUser)
    }

    fun update(email: String, updated: User): User {
        val existing = findByEmail(email)
        val saved = existing.copy(
            name = updated.name,
            duoc = updated.duoc,
            points = updated.points,
            password = if (updated.password.isNotBlank())
                passwordEncoder.encode(updated.password)
            else
                existing.password
        )
        return repo.save(saved)
    }

    fun delete(email: String) = repo.deleteById(email)

    // ⭐ NUEVO: sumar puntos al usuario
    fun addPoints(email: String, delta: Int): User {
        val existing = findByEmail(email)
        val updated = existing.copy(points = existing.points + delta)
        return repo.save(updated)
    }
}
