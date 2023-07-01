package com.example.mysqlmongo.api.dto.request

import com.example.mysqlmongo.model.mongo.chat.Chat

data class CreateChatRequest(
    val senderId: Long,
    val receiverId: Long,
    val contents: String
) {
    fun toEntity() = Chat(
        senderId = senderId,
        receiverId = receiverId,
        contents = contents
    )
}