package com.example.mysqlmongo.api.service

import com.example.mysqlmongo.api.dto.request.user.CreateUserRequest
import com.example.mysqlmongo.api.dto.request.user.UpdateUserRequest
import com.example.mysqlmongo.model.jpa.user.UserRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun saveUser(request: CreateUserRequest): Long {
        return userRepository.save(request.toEntity()).id
    }

    @Transactional
    fun updateUser(id: Long, request: UpdateUserRequest): Long {
        val user = userRepository.findById(id).orElseThrow()
        user.updateNickname(request.nickname)
        return user.id
    }
}