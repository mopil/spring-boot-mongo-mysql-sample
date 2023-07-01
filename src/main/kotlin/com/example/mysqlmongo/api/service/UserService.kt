package com.example.mysqlmongo.api.service

import com.example.mysqlmongo.model.jpa.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
}