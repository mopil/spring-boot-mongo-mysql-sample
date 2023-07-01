package com.example.mysqlmongo.api.service

import com.example.mysqlmongo.api.dto.request.chat.CreateChatRequest
import com.example.mysqlmongo.api.dto.request.chat.GetChatByConditionRequest
import com.example.mysqlmongo.api.dto.request.chat.UpdateChatRequest
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
        return chatRepository.save(request.toEntity()).id!!
    }

    fun getChat(id: String): Chat {
        return chatRepository.findById(id).orElseThrow()
    }

    fun getChatsByCondition(request: GetChatByConditionRequest): List<Chat> {
        return chatRepository.findAllByCondition(request.senderId, request.receiverId)
    }

    @Transactional
    fun updateChat(id: String, request: UpdateChatRequest): String {
        val chat = chatRepository.findById(id).orElseThrow()
        chat.updateContents(request.contents)
        chatRepository.save(chat)
        return chat.id!!
    }

    @Transactional
    fun deleteChat(id: String) {
        chatRepository.deleteById(id)
    }

}