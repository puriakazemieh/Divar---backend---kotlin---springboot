package com.kazemieh.divar.core.category.service

import com.kazemieh.divar.core.category.entity.Category
import com.kazemieh.divar.core.category.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val repository: CategoryRepository
) {

    fun findAll(): List<Category> {
        return repository.findAll().filter { it.parent == null }
    }

    fun save(entity: Category): Category {
        return repository.save(entity)
    }

    fun saveAll(entity: List<Category>): MutableList<Category> {
        return repository.saveAll(entity)
    }

    fun count(): Long {
        return repository.count()
    }

}