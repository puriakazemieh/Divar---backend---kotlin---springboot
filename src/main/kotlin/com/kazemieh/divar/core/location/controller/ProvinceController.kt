package com.kazemieh.divar.core.location.controller

import com.kazemieh.divar.core.location.entity.Province
import com.kazemieh.divar.core.location.repository.ProvinceRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProvinceController(
    val service: ProvinceRepository
) {

    @GetMapping("api/v1/province")
    fun getProvince(): List<Province> {
        return service.findAll()
    }

}