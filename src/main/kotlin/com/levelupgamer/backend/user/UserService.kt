package com.levelupgamer.backend.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val repo: UserRepository
) {

    fun findAll(): List<User> = repo.findAll()

    fun findByEmail(email: String): User =
        repo.findById(email).orElseThrow { RuntimeException("Usuario no encontrado") }

    fun create(user: User): User = repo.save(user)

    fun update(email: String, updated: User): User {
        val existing = findByEmail(email)
        val toSave = existing.copy(
            name = updated.name,
            duoc = updated.duoc,
            points = updated.points
        )
        return repo.save(toSave)
    }

    fun delete(email: String) = repo.deleteById(email)
}
