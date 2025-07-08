package com.pucetec.exam2.models

import jakarta.persistence.*

@Entity
@Table(name = "vehicles")
data class Vehicle(
    @Id
    @Column(name = "license_plate", length = 20)
    val licensePlate: String,

    @Column(name = "type", nullable = false)
    val type: String, // Ej: CAR, MOTORCYCLE

    @Column(name = "entry_time")
    val entryTime: Long = System.currentTimeMillis()
)



