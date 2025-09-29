package com.kazemieh.divar.core.user.dto

import com.kazemieh.divar.core.user.entity.User
import java.time.Instant


data class UserResponse(
    val name: String,
    val family: String,
    val email: String,
    val token: String,
    val mobile: String,
    val createdAt: Instant? = null,
    val updatedAt: Instant? = null,
)

fun User.toResponse(token: String): UserResponse {
    return UserResponse(
        name = name,
        family = family,
        email = email,
        token = token,
        mobile = mobile,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}