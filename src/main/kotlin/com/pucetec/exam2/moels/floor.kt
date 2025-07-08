package com.pucetec.exam2.models

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "floors")
data class Floor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "floor_number", nullable = false, unique = true)
    val floorNumber: Int,

    @Column(name = "capacity", nullable = false)
    val capacity: Int
)