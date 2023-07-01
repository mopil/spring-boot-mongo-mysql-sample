package com.example.mysqlmongo.api.dto.request

data class GetChatByConditionRequest(
    val senderId: Long,
    val receiverId: Long
)