package com.example.mysqlmongo.api.service

import com.example.mysqlmongo.api.dto.request.CreateChatRequest
import com.example.mysqlmongo.model.mongo.chat.Chat
import com.example.mysqlmongo.model.mongo.chat.ChatRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatService(
    private val chatRepository: ChatRepository
) {

    @Transactional
    fun saveChat(request: CreateChatRequest): String {
        val chat = chatRepository.save(request.toEntity())
        return chat.id!!
    }

    fun getChat(id: String): Chat {
        return chatRepository.findById(id).orElseThrow()
    }

    fun deleteChat(id: String) {
        chatRepository.deleteById(id)
    }

}