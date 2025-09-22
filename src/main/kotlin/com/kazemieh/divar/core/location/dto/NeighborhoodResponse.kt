package com.kazemieh.divar.core.location.dto

import com.kazemieh.divar.core.location.entity.Neighborhood

data class NeighborhoodResponse(
    val id: Long,
    val name: String
)

fun Neighborhood.toResponse(): NeighborhoodResponse {
    return NeighborhoodResponse(id = id, name = name)
}
