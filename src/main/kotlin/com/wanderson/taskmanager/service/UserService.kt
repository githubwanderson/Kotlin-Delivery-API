package com.wanderson.taskmanager.service

import com.wanderson.taskmanager.dto.UserRequestDTO
import com.wanderson.taskmanager.dto.UserResponseDTO
import com.wanderson.taskmanager.entity.User
import com.wanderson.taskmanager.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll(): List<UserResponseDTO> {
        return userRepository.findByActiveTrue().map { UserResponseDTO(it.id, it.name, it.email, it.active) }
    }

    fun create(dto: UserRequestDTO): UserResponseDTO {
        val newUser = User(
            name = dto.name,
            email = dto.email,
            password = dto.password
        )

        var savedUser = userRepository.save(newUser)

        return UserResponseDTO(savedUser.id, savedUser.name, savedUser.email, savedUser.active)
    }


}