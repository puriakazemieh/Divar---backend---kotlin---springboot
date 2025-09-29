package com.kazemieh.divar.core.user.controller

import com.kazemieh.divar.core.user.dto.UserRequest
import com.kazemieh.divar.core.user.dto.toEntity
import com.kazemieh.divar.core.user.dto.toResponse
import com.kazemieh.divar.core.user.service.UserService
import com.kazemieh.divar.utils.response.ApiResponse
import com.kazemieh.divar.utils.response.BadRequestError
import com.kazemieh.divar.utils.response.UnauthorizedError
import com.kazemieh.divar.utils.security.JwtService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/")
class UserController(
    val service: UserService,
    val jwtService: JwtService
) {

    @PostMapping("user")
    fun register(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        return if (userRequest == null) ApiResponse.error(BadRequestError())
        else if (service.findByEmail(userRequest.email) != null)
            ApiResponse.error(BadRequestError(message = "کاربر با این ایمیل وجود داره"))
        else {
            val user = userRequest.toEntity()
            val token = jwtService.generate(user)
            val savedUser = service.save(user)
            val userResponse = savedUser.toResponse(token)
            return ApiResponse.success(userResponse)
        }
    }

    @PutMapping("user")
    fun updateUser(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        if (userRequest == null) return ApiResponse.error(BadRequestError())
        return service.findByEmail(userRequest.email)?.let { dbUser ->
            val user = userRequest.toEntity()
            val updateUser = service.save(user.copy(id = dbUser.id))
            ApiResponse.success(updateUser.toResponse(""))
        } ?: run {
            ApiResponse.error(BadRequestError(message = "کاربری با این مشخصات یافت نشد"))
        }

    }

    @GetMapping("user")
    fun getUser(
        @RequestHeader("Authorization") token: String?,
    ): Any? {
        return if (token.isNullOrEmpty()) ApiResponse.error(BadRequestError())
        else {
            val mobile = jwtService.extractMobile(token)
            if (mobile.isNullOrEmpty())
                ApiResponse.error(UnauthorizedError())
            else {
                service.findByMobile(mobile)?.let { dbUser ->
                    val response = dbUser.toResponse(token)
                    ApiResponse.success(response)
                } ?: run {
                    ApiResponse.error(BadRequestError(message = "کاربری با این مشخصات یافت نشد"))
                }
            }
        }
    }

}