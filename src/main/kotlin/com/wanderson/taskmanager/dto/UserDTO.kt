package com.wanderson.taskmanager.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserRequestDTO(

    @field:NotBlank(message = "The name cannot be blank")
    @field:Size(min = 3, max = 255, message = "Name must be between 3 and 255")
    val name: String,

    @field:NotBlank(message = "The email cannot be blank")
    @field:Email(message = "The email is not valid")
    val email: String,

    @field:NotBlank(message = "The password cannot be blank")
    @field:Size(min = 8, max = 255, message = "Password must be between 3 and 255")
    val password: String
)

data class UserResponseDTO(
    val id: Long?,
    val name: String,
    val email: String,
    val active: Boolean
)