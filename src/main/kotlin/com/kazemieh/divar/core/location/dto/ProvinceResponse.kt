package com.kazemieh.divar.core.location.dto

import com.kazemieh.divar.core.location.entity.Province

data class ProvinceResponse(
    val id: Long,
    val name: String,
    val cities: List<CityResponse>? = null,
)

fun Province.toResponse(includeCities: Boolean = true, includeNeighborhood: Boolean = true): ProvinceResponse {
    return ProvinceResponse(id = id, name = name, cities = if (includeCities) cities.map { it.toResponse(includeNeighborhood) } else null)
}
