package com.example.mysqlmongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.example.mysqlmongo.model.jpa"])
@EnableMongoRepositories(basePackages = ["com.example.mysqlmongo.model.mongo"])
@EnableMongoAuditing
class MysqlMongoApplication

fun main(args: Array<String>) {
	runApplication<MysqlMongoApplication>(*args)
}
