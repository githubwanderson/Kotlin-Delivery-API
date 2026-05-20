package com.wanderson.taskmanager.repository

import com.wanderson.taskmanager.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByActiveTrue(): List<User>
}