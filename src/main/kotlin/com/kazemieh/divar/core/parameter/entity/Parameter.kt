package com.kazemieh.divar.core.parameter.entity

import com.kazemieh.divar.core.category.entity.Category
import jakarta.persistence.*

@Entity(name = "parameter")
data class Parameter(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val dataType: DataType,
    val acceptedOptions: String? = null,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    val category: Category,
)


enum class DataType {
    StringInput,
    NumberInput,
    CheckBoxInput,
    FixedOption
}