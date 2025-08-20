package com.kazemieh.divar.core.location.entity

import jakarta.persistence.*

@Entity(name = "neighborhood")
data class Neighborhood(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "City_id")
    val province: City,
)