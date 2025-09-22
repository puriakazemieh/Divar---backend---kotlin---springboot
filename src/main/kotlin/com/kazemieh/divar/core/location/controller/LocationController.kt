package com.kazemieh.divar.core.location.controller

import com.kazemieh.divar.core.location.dto.ProvinceResponse
import com.kazemieh.divar.core.location.dto.toResponse
import com.kazemieh.divar.core.location.service.ProvinceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class LocationController(
    val service: ProvinceService
) {

    @GetMapping("location")
    fun getLocation(): List<ProvinceResponse> {
        return service.findAll().map { it.toResponse() }
    }

}