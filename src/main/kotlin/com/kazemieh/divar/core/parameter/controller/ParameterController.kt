package com.kazemieh.divar.core.parameter.controller

import com.kazemieh.divar.core.parameter.service.ParameterService
import com.kazemieh.divar.utils.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class ParameterController(
    val service: ParameterService
) {

    @GetMapping("parameter")
    fun getParameter(): ResponseEntity<*> {
        return ApiResponse.success(service.findAll())
    }

}