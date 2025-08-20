package com.kazemieh.divar.core.parameter.entity

import com.kazemieh.divar.core.category.entity.Category
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "parameter")
data class Parameter(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val dataType: String,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    val category: Category,
)