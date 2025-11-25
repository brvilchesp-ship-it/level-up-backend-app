package com.levelupgamer.backend.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
class UserController(
    private val service: UserService
) {

    @GetMapping
    fun getAll(): List<User> = service.findAll()

    @GetMapping("/{email}")
    fun getByEmail(@PathVariable email: String): User = service.findByEmail(email)

    @PostMapping
    fun create(@RequestBody user: User): User = service.create(user)

    @PutMapping("/{email}")
    fun update(
        @PathVariable email: String,
        @RequestBody user: User
    ): User = service.update(email, user)

    @DeleteMapping("/{email}")
    fun delete(@PathVariable email: String) = service.delete(email)
}
