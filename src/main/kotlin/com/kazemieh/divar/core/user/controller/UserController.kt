package com.kazemieh.divar.core.user.controller

import com.kazemieh.divar.core.user.dto.UserRequest
import com.kazemieh.divar.core.user.dto.toEntity
import com.kazemieh.divar.core.user.dto.toResponse
import com.kazemieh.divar.core.user.service.UserService
import com.kazemieh.divar.utils.security.JwtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class UserController(
    val service: UserService,
    val jwtService: JwtService
) {

    @PostMapping("user")
    fun addUser(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        return if (userRequest == null) return "لطفا اطلاعات کاربر را وارد نمایید"
        else {
            val user = userRequest.toEntity()
            val token = jwtService.generate(user)
            val savedUser = service.save(user)
            savedUser.toResponse(token)
        }
    }

    @GetMapping("user")
    fun getUser(
        @RequestHeader("Authorization") token: String?,
    ): Any? {
        return if (token.isNullOrEmpty()) "لطفا مقادیر مورد نیاز را وارد نمایید"
        else {
            val mobile = jwtService.extractMobile(token)
            if (mobile.isNullOrEmpty()) "موبایل معتبر نیست "
            else {
               val user = service.findByMobile(mobile)
                return user?.toResponse(token)
            }
        }
    }

}