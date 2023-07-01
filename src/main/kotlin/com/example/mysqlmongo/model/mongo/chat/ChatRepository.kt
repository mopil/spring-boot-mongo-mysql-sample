package com.example.mysqlmongo.model.mongo.chat

import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRepository : MongoRepository<Chat, String> {
}