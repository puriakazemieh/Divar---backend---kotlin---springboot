package com.kazemieh.divar.core.parameter.repository

import com.kazemieh.divar.core.parameter.entity.Parameter
import org.springframework.data.jpa.repository.JpaRepository

interface ParameterRepository : JpaRepository<Parameter, Long> {
}