package com.pucetec.exam2.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tickets")
data class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "license_plate", nullable = false)
    val licensePlate: String,

    @Column(name = "entry_time", nullable = false)
    val entryTime: LocalDateTime,

    @Column(name = "exit_time")
    var exitTime: LocalDateTime? = null,

    @Column(name = "total_cost")
    var totalCost: Double? = null
)