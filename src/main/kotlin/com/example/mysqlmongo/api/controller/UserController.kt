package com.example.mysqlmongo.api.controller

import com.example.mysqlmongo.api.dto.request.user.CreateUserRequest
import com.example.mysqlmongo.api.dto.request.user.UpdateUserRequest
import com.example.mysqlmongo.api.dto.response.ApiResponse
import com.example.mysqlmongo.api.service.UserService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/user")
    fun createUser(@RequestBody request: CreateUserRequest): ApiResponse<Long> {
        return ApiResponse(userService.saveUser(request))
    }

    @PutMapping("/user/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody request: UpdateUserRequest
    ): ApiResponse<Long> {
        return ApiResponse(userService.updateUser(id, request))
    }
}