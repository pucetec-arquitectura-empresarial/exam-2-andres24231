package com.pucetec.exam2.services

import com.pucetec.exam2.models.ParkingSpot
import com.pucetec.exam2.repository.ParkingSpotRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ParkingSpotService(
    private val parkingSpotRepository: ParkingSpotRepository
) {

    fun getAllSpots(): List<ParkingSpot> = parkingSpotRepository.findAll()

    fun getSpotById(id: Long): Optional<ParkingSpot> = parkingSpotRepository.findById(id)

    fun saveSpot(spot: ParkingSpot): ParkingSpot = parkingSpotRepository.save(spot)

    fun deleteSpot(id: Long) = parkingSpotRepository.deleteById(id)

    @Transactional
    fun enterVehicle(licensePlate: String, floorId: Long): String {
        val availableSpot = parkingSpotRepository.findByFloorIdAndOccupied(floorId, false).firstOrNull()
            ?: return "No hay espacios disponibles en este piso."

        availableSpot.occupied = true
        availableSpot.vehicleLicensePlate = licensePlate
        parkingSpotRepository.save(availableSpot)

        return "Vehículo $licensePlate estacionado en espacio ID: ${availableSpot.id}"
    }

    @Transactional
    fun exitVehicle(licensePlate: String): String {
        val spot = parkingSpotRepository.findByVehicleLicensePlate(licensePlate)
            ?: return "Vehículo no encontrado."

        spot.occupied = false
        spot.vehicleLicensePlate = null
        parkingSpotRepository.save(spot)

        return "Vehículo $licensePlate ha salido del parqueadero."
    }
}