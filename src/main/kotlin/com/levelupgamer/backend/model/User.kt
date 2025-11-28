package com.levelupgamer.backend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(

    @Id
    @Column(unique = true, nullable = false)
    val email: String = "",

    @Column(nullable = false)
    val name: String = "",

    // ¿Es correo DUOC?
    @Column(nullable = false)
    val duoc: Boolean = false,

    @Column(nullable = false)
    val points: Int = 0,

    // 🔐 NUEVO: password encriptado (BCrypt)
    @Column(nullable = false)
    val password: String = ""
)