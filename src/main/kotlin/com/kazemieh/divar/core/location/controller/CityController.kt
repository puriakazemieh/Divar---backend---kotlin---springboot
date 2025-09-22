package com.kazemieh.divar.core.location.controller

import com.kazemieh.divar.core.location.dto.CityResponse
import com.kazemieh.divar.core.location.dto.toResponse
import com.kazemieh.divar.core.location.service.CityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class CityController(
    val service: CityService
) {

    @GetMapping("city")
    fun getCity(): List<CityResponse> {
        return service.findAll().map { it.toResponse(false) }
    }

}