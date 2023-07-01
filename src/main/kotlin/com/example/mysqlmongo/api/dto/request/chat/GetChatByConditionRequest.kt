package com.example.mysqlmongo.api.dto.request.chat

data class GetChatByConditionRequest(
    val senderId: Long,
    val receiverId: Long
)