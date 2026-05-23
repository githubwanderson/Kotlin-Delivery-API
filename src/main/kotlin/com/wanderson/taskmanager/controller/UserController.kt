package com.wanderson.taskmanager.controller

import com.wanderson.taskmanager.dto.UserRequestDTO
import com.wanderson.taskmanager.dto.UserResponseDTO
import com.wanderson.taskmanager.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserResponseDTO>> {
        return ResponseEntity.ok(userService.findAll())
    }

    @PostMapping
    fun create(@Valid @RequestBody dto: UserRequestDTO): ResponseEntity<UserResponseDTO> {
        val createdUser = userService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<UserResponseDTO> {
        val user = userService.findById(id)
        return if (user != null) ResponseEntity.ok(user)
        else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun update(@Valid @PathVariable id: Long, @RequestBody dto: UserRequestDTO): ResponseEntity<UserResponseDTO> {
        val updatedUser = userService.update(id, dto)
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser)
    }
}