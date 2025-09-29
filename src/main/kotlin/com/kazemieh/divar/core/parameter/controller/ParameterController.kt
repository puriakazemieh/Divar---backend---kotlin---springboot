package com.kazemieh.divar.core.parameter.controller

import com.kazemieh.divar.core.parameter.dto.toResponse
import com.kazemieh.divar.core.parameter.service.ParameterService
import com.kazemieh.divar.utils.response.ApiResponse
import com.kazemieh.divar.utils.response.GoneError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class ParameterController(
    val service: ParameterService
) {

    @GetMapping("parameter")
    fun getParameter(
        @RequestParam(name = "categoryId") categoryId: Long? = null,
    ): ResponseEntity<*> {
        return if (categoryId == null) {
            ApiResponse.success(service.findAll().map { it.toResponse(true) })
        } else {
            service.findByCategory(categoryId)?.map { it.toResponse(false) }?.let {
                ApiResponse.success(it)
            }?: run {
                ApiResponse.error(GoneError(message = "دسته بندی پیدا نشد"))
            }
        }
    }

}