package com.example.mysqlmongo.model.mongo.chat

import com.example.mysqlmongo.model.MongoBaseTimeEntity
import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "chat")
open class Chat(
    val senderId: Long,
    val receiverId: Long,
    contents: String,
    val hashTags: List<String> = emptyList()
) : MongoBaseTimeEntity() {
    /*
    id에 auto increment를 하기 위해서는 초기값을 String, nullable하게 설정해야하고
    val 대신 var로 선언해야 정상 작동한다. 혹시나 모를 id 변경지점을 없애기 위해 private로 선언한다.
     */
    @Id
    var id: String? = null
        private set
    var contents: String = contents
        private set

    fun updateContents(contents: String) {
        this.contents = contents
    }
}