package com.wanderson.taskmanager.service

import com.wanderson.taskmanager.dto.UserRequestDTO
import com.wanderson.taskmanager.dto.UserResponseDTO
import com.wanderson.taskmanager.entity.User
import com.wanderson.taskmanager.exception.ResourceNotFoundException
import com.wanderson.taskmanager.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll(): List<UserResponseDTO> {
        return userRepository.findByActiveTrue().map { UserResponseDTO(it.id, it.name, it.email, it.active) }
    }

    fun findById(id: Long): UserResponseDTO? {
        return userRepository.findById(id)
            .map { UserResponseDTO(it.id, it.name, it.email, it.active) }
            .orElse(null)
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

    fun update(id: Long, dto: UserRequestDTO): UserResponseDTO {
        val user = userRepository.findById(id).orElseThrow { ResourceNotFoundException("User not found") }

        user.name = dto.name
        user.email = dto.email
        user.password = dto.password

        userRepository.save(user)

        return UserResponseDTO(user.id, user.name, user.email, user.active)
    }


}