package com.levelupgamer.backend.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    val email: String = "",
    val name: String = "",
    val duoc: Boolean = false,
    val points: Int = 0
)

