package com.kazemieh.divar.core.location.service

import com.kazemieh.divar.core.location.entity.Province
import com.kazemieh.divar.core.location.repository.ProvinceRepository
import org.springframework.stereotype.Service

@Service
class ProvinceService(
    val repository: ProvinceRepository
) {

    fun findAll(): List<Province> {
        return repository.findAll()
    }

    fun save(entity: Province): Province {
        return repository.save(entity)
    }

    fun saveAll(entity: List<Province>): MutableList<Province> {
        return repository.saveAll(entity)
    }

    fun countProvince(): Long {
        return repository.count()
    }

}