package com.wanderson.taskmanager.controller

import com.wanderson.taskmanager.dto.UserRequestDTO
import com.wanderson.taskmanager.dto.UserResponseDTO
import com.wanderson.taskmanager.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
}