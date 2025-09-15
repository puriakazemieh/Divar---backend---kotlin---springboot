package com.kazemieh.divar.core.location.repository

import com.kazemieh.divar.core.location.entity.Province
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRepository : JpaRepository<Province, Long> {

}