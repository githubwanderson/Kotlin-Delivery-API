package com.wanderson.taskmanager.service

import com.wanderson.taskmanager.dto.UserRequestDTO
import com.wanderson.taskmanager.dto.UserResponseDTO
import com.wanderson.taskmanager.entity.User
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class UserService {
    private val fakeDatabase = mutableListOf<User>()
    private val idGenerator = AtomicLong(1)

    init {
        fakeDatabase.add(
            User(idGenerator.getAndIncrement(), "Wanderson", "wanderson@gmail.com", "123456")
        )
    }

    fun findAll(): List<UserResponseDTO> {
        return fakeDatabase
            .filter {it.active}
            .map { UserResponseDTO(it.id, it.name, it.email, it.active) }
    }

    fun create(dto: UserRequestDTO): UserResponseDTO {
        val newUser = User(
            id = idGenerator.getAndIncrement(),
            name = dto.name,
            email = dto.email,
            password = dto.password,
        )
        fakeDatabase.add(newUser)

        return UserResponseDTO(newUser.id, newUser.name, newUser.email, newUser.active)
    }


}