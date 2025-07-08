package com.pucetec.exam2.models

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "parking_spots")
data class ParkingSpot(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "spot_number", nullable = false)
    val spotNumber: Int,

    @Column(name = "occupied")
    var occupied: Boolean = false,

    @Column(name = "vehicle_license_plate", nullable = true)
    var vehicleLicensePlate: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "floor_id", nullable = false)
    val floor: Floor
)