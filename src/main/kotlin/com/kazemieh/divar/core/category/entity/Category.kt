package com.kazemieh.divar.core.category.entity

import jakarta.persistence.*

@Entity(name = "category")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val icon: String,
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    val category: Category? = null,
)