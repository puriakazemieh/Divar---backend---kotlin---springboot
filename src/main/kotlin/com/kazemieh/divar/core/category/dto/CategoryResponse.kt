package com.kazemieh.divar.core.category.dto

import com.kazemieh.divar.core.category.entity.Category

data class CategoryResponse(
    val id: Long,
    val name: String,
    val icon: String,
    val children: List<CategoryResponse>? = null,
)

fun Category.toResponse(includeParent: Boolean = true): CategoryResponse {
    return CategoryResponse(
        id = id,
        name = name,
        icon = icon,
        children = if (includeParent) children.map { it.toResponse() } else null)
}
