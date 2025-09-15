package com.kazemieh.divar.core.location.repository

import com.kazemieh.divar.core.location.entity.Neighborhood
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NeighborhoodRepository : JpaRepository<Neighborhood, Long> {

}