package com.example.mysqlmongo.model.mongo.chat

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface ChatRepository : MongoRepository<Chat, String> {
    fun findAllBySenderId(senderId: Long): List<Chat>

    @Query("{'senderId': { \$gte: ?0 }, 'receiverId': ?1, 'contents': { \$ne: '' }}")
    fun findAllByCondition(senderId: Long, receiverId: Long): List<Chat>
}