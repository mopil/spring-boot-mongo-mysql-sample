package com.example.mysqlmongo.api.controller

import com.example.mysqlmongo.api.dto.request.CreateChatRequest
import com.example.mysqlmongo.api.dto.request.GetChatByConditionRequest
import com.example.mysqlmongo.api.dto.response.ApiResponse
import com.example.mysqlmongo.api.service.ChatService
import com.example.mysqlmongo.model.mongo.chat.Chat
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val chatService: ChatService
) {
    @PostMapping("/chat")
    fun saveChat(@RequestBody request: CreateChatRequest): ApiResponse<String> {
        return ApiResponse(chatService.saveChat(request))
    }

    @GetMapping("/chat/{id}")
    fun getChat(@PathVariable id: String): Chat {
        return chatService.getChat(id)
    }

    @GetMapping("/chat/condition")
    fun getChat(@RequestBody request: GetChatByConditionRequest): List<Chat> {
        return chatService.getChatsByCondition(request)
    }

    @DeleteMapping("/chat/{id}")
    fun deleteChat(@PathVariable id: String) {
        chatService.deleteChat(id)
    }
}