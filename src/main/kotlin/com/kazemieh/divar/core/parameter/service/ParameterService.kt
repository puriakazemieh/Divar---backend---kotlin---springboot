package com.kazemieh.divar.core.parameter.service

import com.kazemieh.divar.core.parameter.entity.Parameter
import com.kazemieh.divar.core.parameter.repository.ParameterRepository
import org.springframework.stereotype.Service

@Service
class ParameterService(
    val repository: ParameterRepository
) {


    fun save(entity: Parameter): Parameter {
        return repository.save(entity)
    }

    fun findAll(): List<Parameter> {
        return repository.findAll()
    }

}