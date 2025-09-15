package com.kazemieh.divar.core.location.entity

import jakarta.persistence.*

@Entity(name = "neighborhood")
data class Neighborhood(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "City_id")
    val city: City,
)