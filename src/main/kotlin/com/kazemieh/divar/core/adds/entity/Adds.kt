package com.kazemieh.divar.core.adds.entity

import com.kazemieh.divar.core.image.entity.Image
import com.kazemieh.divar.core.location.entity.Neighborhood
import com.kazemieh.divar.core.user.entity.User
import jakarta.persistence.*

@Entity(name = "adds")
data class Adds(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,
    val description: String,
    val price: String,

    @ManyToOne
    @JoinColumn(name = "neighborhood_id")
    val neighborhood: Neighborhood,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToMany(fetch = FetchType.LAZY)
    val images :List<Image>
)