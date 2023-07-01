package com.example.mysqlmongo.model

import jakarta.persistence.MappedSuperclass
import java.io.Serializable
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field

@MappedSuperclass
abstract class MongoBaseTimeEntity : Serializable {

    @field:Field("createdAt")
    @CreatedDate
    private var _createdAt: LocalDateTime = LocalDateTime.now()

    /*
    Spring Data MongoDB에는 JPA처럼 더티체킹 방식을 지원하지 않아서 @PreUpdate 어노테이션을 이용 불가능
    그래서 @LastModifiedDate를 이용해서 MongoRepository에서 save()를 호출할 때마다 갱신되도록 함
     */
    @field:Field("updatedAt")
    @LastModifiedDate
    private var _updatedAt: LocalDateTime = LocalDateTime.now()
    val createdAt: LocalDateTime
        get() = _createdAt

    val updatedAt: LocalDateTime
        get() = _updatedAt
}

