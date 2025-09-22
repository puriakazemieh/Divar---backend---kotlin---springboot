package com.kazemieh.divar.core.user.dto

import com.kazemieh.divar.core.user.entity.User


data class UserRequest(
    val name: String,
    val family: String,
    val email: String,
    val password: String,
    val mobile: String,
)

fun UserRequest.toEntity(): User {
    return User(name = name, family = family, email = email, password = password, mobile = mobile)
}