package com.kazemieh.divar.core.location.entity

import jakarta.persistence.*

@Entity(name = "City")
data class City(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String? = null,
    @ManyToOne
    @JoinColumn(name = "province_id")
    val province: Province? = null,
)