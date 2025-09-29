package com.kazemieh.divar.core.category.controller

import com.kazemieh.divar.core.category.dto.toResponse
import com.kazemieh.divar.core.category.service.CategoryService
import com.kazemieh.divar.utils.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class CategoryController(
    val service: CategoryService
) {

    @GetMapping("category")
    fun getCategory(): ResponseEntity<*> {
        return ApiResponse.success(service.findAll().map { it.toResponse() })
    }

}