package com.levelupgamer.backend.auth

import com.levelupgamer.backend.security.jwt.JwtService
import com.levelupgamer.backend.user.UserService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
class AuthController(
    private val authManager: AuthenticationManager,
    private val jwtService: JwtService,
    private val userService: UserService
) {
    // ======== DTOs ========
    @JvmRecord
    data class RegisterRequest(val email: String?, val name: String?, val password: String?)

    @JvmRecord
    data class LoginRequest(val email: String?, val password: String?)

    @JvmRecord
    data class AuthResponse(
        val token: String?,
        val email: String?,
        val name: String?,
        val duoc: Boolean,
        val points: Int
    )

    // ==========================
    //          REGISTRO
    // ==========================
    @PostMapping("/register")
    fun register(@RequestBody req: RegisterRequest): AuthResponse {
        val newUser = userService.register(req.email!!, req.name!!, req.password!!)
        val token = jwtService.generateToken(newUser.email)

        return AuthResponse(
            token,
            newUser.email,
            newUser.name,
            newUser.duoc,  // 👈 OJO: getDuoc() (no isDuoc)
            newUser.points
        )
    }

    // ==========================
    //           LOGIN
    // ==========================
    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): AuthResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(req.email, req.password)
        )

        val user = userService.findByEmail(req.email!!)
        val token = jwtService.generateToken(user.email)

        return AuthResponse(
            token,
            user.email,
            user.name,
            user.duoc,  // 👈 lo mismo acá
            user.points
        )
    }
}