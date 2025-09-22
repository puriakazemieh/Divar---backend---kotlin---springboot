package com.kazemieh.divar.core.location.service

import com.kazemieh.divar.core.location.entity.City
import com.kazemieh.divar.core.location.repository.CityRepository
import org.springframework.stereotype.Service

@Service
class CityService(
    val repository: CityRepository
) {

    fun findAll(): List<City> {
        return repository.findAll()
    }

    fun save(entity: City): City {
        return repository.save(entity)
    }

    fun saveAll(entity: List<City>): MutableList<City> {
        return repository.saveAll(entity)
    }

    fun count(): Long {
        return repository.count()
    }

}