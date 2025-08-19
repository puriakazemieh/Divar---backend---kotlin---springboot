package com.kazemieh.divar.core.location.entity

import jakarta.persistence.*

@Entity(name = "Neighborhood")
data class Neighborhood(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String? = null,
    @ManyToOne
    @JoinColumn(name = "City_id")
    val province: City? = null,
)