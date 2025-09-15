package com.kazemieh.divar.core.location.controller

import com.kazemieh.divar.core.location.entity.Province
import com.kazemieh.divar.core.location.service.ProvinceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProvinceController(
    val service: ProvinceService
) {

    @GetMapping("api/v1/province")
    fun getProvince(): List<Province> {
        return service.findAll()
    }

    @PostMapping("api/v1/province")
    fun addProvince(
        @RequestParam name: String?
    ): String {
        return if (name.isNullOrEmpty()) {
            "وارد نشده است نام "
        } else {
            service.save(Province(name = name))
            " با موفقیت ساخته شد دیتا"
        }
    }
}