package com.kazemieh.divar.core.location.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "province")
data class Province(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    val name: String?=null
)
