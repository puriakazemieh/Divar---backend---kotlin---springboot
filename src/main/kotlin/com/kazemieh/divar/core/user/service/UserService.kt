package com.kazemieh.divar.core.user.service

import com.kazemieh.divar.core.user.entity.User
import com.kazemieh.divar.core.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun hashPassword(password: String): String {
        return BCryptPasswordEncoder().encode(password)
    }

    fun save(user: User): User {
        return userRepository.save(user.copy(password = hashPassword(user.password)))
    }
}