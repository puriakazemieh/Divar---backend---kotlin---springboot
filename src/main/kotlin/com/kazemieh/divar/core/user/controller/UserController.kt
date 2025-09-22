package com.kazemieh.divar.core.user.controller

import com.kazemieh.divar.core.user.dto.UserRequest
import com.kazemieh.divar.core.user.dto.toEntity
import com.kazemieh.divar.core.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class UserController(
    val service: UserService
) {

    @PostMapping("user")
    fun addUser(
        @RequestBody user: UserRequest? = null
    ): Any {
        return if (user == null) return "لطفا اطلاعات کاربر را وارد نمایید"
        else service.save(user.toEntity())
    }

}