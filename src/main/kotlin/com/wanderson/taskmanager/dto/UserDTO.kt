package com.wanderson.taskmanager.dto

data class UserRequestDTO(
    val name: String,
    val email: String,
    val password: String
)

data class UserResponseDTO(
    val id: Long?,
    val name: String,
    val email: String,
    val active: Boolean
)