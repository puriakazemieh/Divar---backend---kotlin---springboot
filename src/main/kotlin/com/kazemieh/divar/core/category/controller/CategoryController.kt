package com.kazemieh.divar.core.category.controller

import com.kazemieh.divar.core.category.dto.CategoryResponse
import com.kazemieh.divar.core.category.dto.toResponse
import com.kazemieh.divar.core.category.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class CategoryController(
    val service: CategoryService
) {

    @GetMapping("category")
    fun getCategory(): List<CategoryResponse> {
        return service.findAll().map { it.toResponse() }
    }

}