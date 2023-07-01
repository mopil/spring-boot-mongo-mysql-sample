package com.example.mysqlmongo.api.dto.request.user

import com.example.mysqlmongo.model.jpa.user.User

data class CreateUserRequest(
    val nickname: String
) {
    fun toEntity() = User(
        nickname = nickname
    )
}