package com.pucetec.exam2.services

import com.pucetec.exam2.models.Vehicle
import com.pucetec.exam2.repository.VehicleRepository
import org.springframework.stereotype.Service

@Service
class VehicleService(private val vehicleRepository: VehicleRepository) {

    fun getAllVehicles(): List<Vehicle> = vehicleRepository.findAll()

    fun getVehicleByLicensePlate(plate: String): Vehicle? =
        vehicleRepository.findById(plate).orElse(null)

    fun saveVehicle(vehicle: Vehicle): Vehicle =
        vehicleRepository.save(vehicle)

    fun deleteVehicle(plate: String) = vehicleRepository.deleteById(plate)
}