package com.kazemieh.divar.core.location.entity

import jakarta.persistence.*

@Entity(name = "city")
data class City(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "province_id")
    val province: Province,
)