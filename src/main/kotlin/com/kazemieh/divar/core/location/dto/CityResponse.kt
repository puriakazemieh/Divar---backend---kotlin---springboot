package com.kazemieh.divar.core.location.dto

import com.kazemieh.divar.core.location.entity.City

data class CityResponse(
    val id: Long,
    val name: String,
    val neighborhood: List<NeighborhoodResponse>? = null,
)

fun City.toResponse(isFillNeighborhood: Boolean = true): CityResponse {
    return CityResponse(
        id = id,
        name = name,
        neighborhood = if (isFillNeighborhood) neighborhood.map { it.toResponse() } else null)
}
