package com.kazemieh.divar.core.parameter.entity

import com.kazemieh.divar.core.adds.entity.Adds
import jakarta.persistence.*

@Entity(name = "Parameter_answer")
data class ParameterAnswer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val answer: String,

    @ManyToOne()
    @JoinColumn(name = "adds_id")
    val adds: Adds,

    @ManyToOne()
    @JoinColumn(name = "parameter_id")
    val parameter: Parameter,

    )

