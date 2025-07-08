package com.pucetec.exam2.repository

import com.pucetec.exam2.models.ParkingSpot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkingSpotRepository : JpaRepository<ParkingSpot, Long> {


    fun findByFloorIdAndOccupied(floorId: Long, occupied: Boolean): List<ParkingSpot>


    fun findByVehicleLicensePlate(licensePlate: String): ParkingSpot?
}