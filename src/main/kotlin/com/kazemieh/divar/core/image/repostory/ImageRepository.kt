package com.kazemieh.divar.core.image.repostory

import com.kazemieh.divar.core.image.entity.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, Long> {

}